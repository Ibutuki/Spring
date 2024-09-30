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

@EnableBatchProcessing
//springboot 项目，启动注解， 保证当前为为启动类
@SpringBootApplication
public class StatusStepJob {
	@Autowired
    private JobBuilderFactory jobBuilderFactory;

    //step 构造工厂--用于构造step对象
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Bean
    public Tasklet firstTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("----------------firstTasklet---------------");
                throw new RuntimeException("假装失败了");
                //return RepeatStatus.FINISHED;  //执行完了
            }
        };
    }
    @Bean
    public Tasklet successTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                System.out.println("----------------successTasklet--------------");

                return RepeatStatus.FINISHED;  //执行完了
            }
        };
    }
    @Bean
    public Tasklet failTasklet(){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {

                System.out.println("----------------failTasklet---------------");

                return RepeatStatus.FINISHED;  //执行完了
            }
        };
    }
  //构造一个step对象
    @Bean
    public Step firstStep(){
        //tasklet 执行step逻辑， 类似 Thread()--->可以执行runable接口
        return stepBuilderFactory.get("firstStep")
                .tasklet(firstTasklet())
                .build();
    }
    //构造一个step对象
    @Bean
    public Step successStep(){
        //tasklet 执行step逻辑， 类似 Thread()--->可以执行runable接口
        return stepBuilderFactory.get("successStep")
                .tasklet(successTasklet())
                .build();
    }

    //构造一个step对象
    @Bean
    public Step failStep(){
        //tasklet 执行step逻辑， 类似 Thread()--->可以执行runable接口
        return stepBuilderFactory.get("failStep")
                .tasklet(failTasklet())
                .build();
    }
    @Bean
    public Job job() {
    	return jobBuilderFactory.get("status-step-job")
    			.start(firstStep())
    			.on("FAILED").end()
    			.on("FAILED").fail()
    			.from(firstStep()).on("*").to(successStep())
    			.end()
                .incrementer(new RunIdIncrementer())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(StatusStepJob.class, args);
    }
}
