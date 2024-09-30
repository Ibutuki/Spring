package com.edu.seiryo;

import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class ChunkTaskletJob {
	@Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    int timer  = 3;
    @Bean
    public ItemReader<String> itemReader() {
    	return new ItemReader<String>() {
			@Override
			public  String read()
					throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
				if(timer > 0){
	                System.out.println("-------------read------------");
	                return  "read-ret-" + timer--;
	            }else{
	                return null;
	            }
			}
    	};
    }
    @Bean
    public ItemProcessor<String,String> itemProcessor() {
    	return new ItemProcessor<String,String>() {

			@Override
			public String process(String item) throws Exception {
				System.out.println("-------------process------------>" + item);
                return "process-ret->" + item;
			}
    	};
    }
    @Bean
    public ItemWriter<String> itemWriter(){
        return new ItemWriter<String>() {
            @Override
            public void write(List<? extends String> items) throws Exception {
                System.out.println(items);
            }
        };
    }
    @Bean
    public Step step4(){
        return stepBuilderFactory.get("step4")
                .<String, String>chunk(3)   //设置块的size为3次
                .reader(itemReader())
                .processor(itemProcessor())
                .writer(itemWriter())
                .build();
    }
    //定义作业
    @Bean
    public Job job4(){
        return jobBuilderFactory.get("step-chunk-tasklet-job")
                .start(step4())
                .incrementer(new RunIdIncrementer())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(ChunkTaskletJob.class, args);
    }
}
