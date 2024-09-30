package com.edu.seiryo3;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.edu.seiryo.User;

import java.util.List;

import javax.sql.DataSource;

@SpringBootApplication
@EnableBatchProcessing
public class CursorDBReaderJob {
	  @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;
	    @Autowired
	    private DataSource dataSource;
	    @Bean
	    public UserRowMapper userRowMapper(){
	        return new UserRowMapper();
	    }

	    @Bean
	    public JdbcCursorItemReader<User> userItemReader(){

	        return new JdbcCursorItemReaderBuilder<User>()
	                .name("userCursorItemReader")
	                .dataSource(dataSource)
	                .sql("select * from user")
	                .rowMapper(userRowMapper())
	                .build();
		}

	    @Bean
	    public ItemWriter<User> itemWriter(){
	        return new ItemWriter<User>() {
	            @Override
	            public void write(List<? extends User> items) throws Exception {
	                items.forEach(System.err::println);
	            }
	        };
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
	        return jobBuilderFactory.get("cursor-db-reader-job")
	                .start(step())
	                .build();
	    }
	    public static void main(String[] args) {
	        SpringApplication.run(CursorDBReaderJob.class, args);
	    } 
}
