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

public class ConditionStepJob {
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Tasklet firstTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("--------------firstTasklet---------------");
                return RepeatStatus.FINISHED;
                //throw new RuntimeException("测试fail结果");
            }
        };
    }
    @Bean
    public Tasklet successTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("--------------successTasklet---------------");
                return RepeatStatus.FINISHED;
            }
        };
    }
    @Bean
    public Tasklet failTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("--------------failTasklet---------------");
                return RepeatStatus.FINISHED;
            }
        };
    }
    @Bean
    public Step firstStep(){
        return stepBuilderFactory.get("step1")
                .tasklet(firstTasklet())
                .build();
    }
    @Bean
    public Step successStep(){
        return stepBuilderFactory.get("successStep")
                .tasklet(successTasklet())
                .build();
    }
    @Bean
    public Step failStep(){
        return stepBuilderFactory.get("failStep")
                .tasklet(failTasklet())
                .build();
    }
    @Bean
    public Job job() {
    	return jobBuilderFactory.get("condition-multi-job")
    			.start(firstStep()).on("FAILED").to(failStep())
    			.from(firstStep()).on("*").to(successStep())
    			.end()
    			.incrementer(new RunIdIncrementer())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(ConditionStepJob.class, args);
    }
}
