package com.edu.seiryo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableBatchProcessing
public class MultiStepJob {
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Tasklet tasklet8(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("--------------tasklet1---------------");
                return RepeatStatus.FINISHED;
            }
        };
    }
    
    @Bean
    public Tasklet tasklet9(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("--------------tasklet2---------------");
                return RepeatStatus.FINISHED;
            }
        };
    }
    @Bean
    public Step step8(){
        return stepBuilderFactory.get("step7")
                .tasklet(tasklet8())
                .build();
    }

    @Bean
    public Step step9(){
        return stepBuilderFactory.get("step7")
                .tasklet(tasklet9())
                .build();
    }
    @Bean
    public Job job8() {
    	return jobBuilderFactory.get("job8")
    			.start(step8())
    			.next(step9())
    			.incrementer(new RunIdIncrementer())
    			.build();
    }
    public static void main(String[] args) {
        SpringApplication.run(MultiStepJob.class, args);
    }
}
