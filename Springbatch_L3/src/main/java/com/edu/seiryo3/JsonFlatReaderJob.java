package com.edu.seiryo3;

import com.edu.seiryo.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.JsonItemReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.util.List;

@SpringBootApplication
@EnableBatchProcessing
public class JsonFlatReaderJob {
	 @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;


	    @Bean
	    public JsonItemReader<User> userItemReader(){

	    	ObjectMapper objectMapper = new ObjectMapper();
	    	JacksonJsonObjectReader<User> jsonObjectReader = new JacksonJsonObjectReader<>(User.class);
	        jsonObjectReader.setMapper(objectMapper);

	        return new JsonItemReaderBuilder<User>()
	                .name("userJsonItemReader")
	                .jsonObjectReader(jsonObjectReader)
	                .resource(new ClassPathResource("users.json"))
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
	        return jobBuilderFactory.get("json-flat-reader-job")
	                .start(step())
	                .build();
	    }
	    public static void main(String[] args) {
	        SpringApplication.run(JsonFlatReaderJob.class, args);
	    }
}
