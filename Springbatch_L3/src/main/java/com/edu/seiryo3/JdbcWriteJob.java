package com.edu.seiryo3;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.json.JacksonJsonObjectMarshaller;
import org.springframework.batch.item.json.JsonFileItemWriter;
import org.springframework.batch.item.json.builder.JsonFileItemWriterBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.PathResource;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class JdbcWriteJob {
	  @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;

	    @Autowired
	    private DataSource dataSource;

	    @Bean
	    public FlatFileItemReader<User> userItemReader(){
	        return new FlatFileItemReaderBuilder<User>()
	                .name("userItemReader")
	                .resource(new ClassPathResource("users.txt"))
	                .delimited().delimiter("#")
	                .names("id", "name", "age")
	                .targetType(User.class)
	                .build();
	    }
	    @Bean
	    public UserPreStatementSetter preStatementSetter(){
	        return new UserPreStatementSetter();
	    }
	    @Bean
	    public JdbcBatchItemWriter<User>  itemWriter(){
	        return new JdbcBatchItemWriterBuilder<User>()
	                .dataSource(dataSource)
	                .sql("insert into user(id, name, age) values(?,?,?)")
	                .itemPreparedStatementSetter(preStatementSetter())
	                .build();
	    }
	    @Bean
	    public Step step(){
	        return stepBuilderFactory.get("step1")
	                .<User, User>chunk(1)
	                .reader(userItemReader())
	                .writer(itemWriter())
	                .build();
	    }

	    @Bean
	    public Job job(){
	        return jobBuilderFactory.get("jdbc-writer-job")
	                .start(step())
	                .build();
	    }
	    public static void main(String[] args) {
	        SpringApplication.run(JdbcWriteJob.class, args);
	    }
}
