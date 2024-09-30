package com.edu.seiryo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;

public class StatusListenerJob {
	@Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Bean
    public Tasklet tasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                JobExecution jobExecution = contribution.getStepExecution().getJobExecution();
                System.err.println("执行中-status：" + jobExecution.getStatus());
                return RepeatStatus.FINISHED;
            }
        };
    }

    //状态监听器，不写注释要定义bean
//    @Bean
//    public JobStateListener jobStateListener(){
//        return new JobStateListener();
//    }

    @Bean
    public Step  step8(){
        return  stepBuilderFactory.get("step8")
                .tasklet(tasklet())
                .build();
    }
    @Bean
    public Job job8(){
        return jobBuilderFactory.get("job8")
                .start(step8())
//                .listener(jobStateListener())  //设置状态监听器
                //注解建立bean
                .listener(JobListenerFactoryBean.getListener(new JobStateListener()))
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(StatusListenerJob.class, args);
    }
}
