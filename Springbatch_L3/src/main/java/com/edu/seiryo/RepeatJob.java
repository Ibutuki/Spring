package com.edu.seiryo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class RepeatJob {
	 @Autowired
	    private JobLauncher jobLauncher;
	    @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;
	    @Bean
	    public Tasklet tasklet3(){
	        return new Tasklet() {
	            @Override
	            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	                System.out.println("------>" + System.currentTimeMillis());
	                //return RepeatStatus.CONTINUABLE;  //循环执行
	                return RepeatStatus.FINISHED;
	            }
	        };
	    }
	    @Bean
	    public Step step3(){
	        return stepBuilderFactory.get("step3")
	                .tasklet(tasklet3())
	                .build();
	    }
	    //定义作业
	    @Bean
	    public Job job3(){
	        return jobBuilderFactory.get("step-simple-tasklet-job")
	                .start(step3())
	                .build();
	    }
	    public static void main(String[] args) {
	        SpringApplication.run(RepeatJob.class, args);
	    }
}
