package com.edu.seiryo;

import java.util.Arrays;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.CompositeJobParametersValidator;
import org.springframework.batch.core.job.DefaultJobParametersValidator;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
@EnableBatchProcessing
public class ParamJob {
	//job构造器工厂
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    //step构造器工厂
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

//    @Bean
//    public Tasklet tasklet1(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println("param SpringBatch....");
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
    
//    @Bean
//    public Tasklet tasklet2(){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                Map<String, Object> parameters = chunkContext.getStepContext().getJobParameters();
//                System.out.println("params---name:" + parameters.get("name"));
//                return RepeatStatus.FINISHED;
//            }
//        };
//    }
    //不用map
    @StepScope
    @Bean
    public Tasklet tasklet3(@Value("#{jobParameters['name']}")String name){
        return new Tasklet() {
            @Override
            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
                System.out.println("params---name:" + name);
                return RepeatStatus.FINISHED;
            }
        };
    }
//    @Bean
//    public Step  step3(){
//        return  stepBuilderFactory.get("step3")
//                .tasklet(tasklet3())
//                .build();
//    }
    //3
    @Bean
	  public Step  step6(){
	      return  stepBuilderFactory.get("step6")
	              .tasklet(null)
	              .build();
	  }
  //配置name参数校验器
    @Bean
    public ParamValidator validator(){
        return new ParamValidator();
    }
    @Bean
    public DefaultJobParametersValidator defaultValidator(){
        DefaultJobParametersValidator defaultValidator = new DefaultJobParametersValidator();
        defaultValidator.setRequiredKeys(new String[]{"name"});  //必填
        defaultValidator.setOptionalKeys(new String[]{"age"});   //可选
        return defaultValidator;
    }
  //配置组合参数校验器
    @Bean
    public CompositeJobParametersValidator compositeValidator(){

        DefaultJobParametersValidator defaultValidator = new DefaultJobParametersValidator();
        defaultValidator.setRequiredKeys(new String[]{"name"});  //name必填
        defaultValidator.setOptionalKeys(new String[]{"age"});   //age可选

        ParamValidator nameParamValidator = new ParamValidator();  //name 不能为空

        CompositeJobParametersValidator compositeValidator = new CompositeJobParametersValidator();
        //按照传入的顺序，先执行defaultValidator 后执行nameParamValidator
        compositeValidator.setValidators(Arrays.asList(defaultValidator, nameParamValidator));

        try {
            compositeValidator.afterPropertiesSet();  //判断校验器是否为null
        } catch (Exception e) {
            e.printStackTrace();
        }

        return compositeValidator;
    }
    @Bean
    public Job job6(){
        return jobBuilderFactory.get("job6")
                .start(step6())
//                .validator(validator())
//                .validator(defaultValidator())
                .validator(compositeValidator())
                .build();
    }
    public static void main(String[] args) {
        SpringApplication.run(HelloBatch.class, args);
    }
}

