package com.edu.seiryo.config;

import java.io.File;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.PathResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

import com.edu.seiryo.entity.Employee;
import com.edu.seiryo.listener.CsvToDBJobListener;

@Configuration
public class CsvToDBJobConfig {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Value("${job.data.path}")
	private String path;
	
	@Bean
	public FlatFileItemReader<Employee> cvsToDBItemReader(){
		FlatFileItemReader<Employee> reader = new FlatFileItemReaderBuilder<Employee>()
				.name("employeeCSVItemReader")
				.saveState(false)
				.resource(new PathResource(new File(path, "employee.csv").getAbsolutePath()))
				.delimited()
                .names("id", "name", "age", "sex")
                .targetType(Employee.class)
                .build();
		return reader;
	}
	@Bean
	public MyBatisBatchItemWriter<Employee> cvsToDBItemWriter(){
		 MyBatisBatchItemWriter<Employee> itemWriter = new MyBatisBatchItemWriter<>();
		 itemWriter.setSqlSessionFactory(sqlSessionFactory); //需要指定sqlsession工厂
	        //指定要操作sql语句，路径id为：EmployeeMapper.xml定义的sql语句id
        itemWriter.setStatementId("com.edu.seiryo.mapper.EmployeeMapper.saveTemp");  //操作sql
        return itemWriter;
	}
	@Bean
    public Step csvToDBStep(){
        return stepBuilderFactory.get("csvToDBStep")
                .<Employee, Employee>chunk(10000)  //每个块10000个 共50个
                .reader(cvsToDBItemReader())
                .writer(cvsToDBItemWriter())
                .taskExecutor(new SimpleAsyncTaskExecutor())  //多线程读写
                .build();

    }
	//job监听器
    @Bean
    public CsvToDBJobListener csvToDBJobListener(){
        return new CsvToDBJobListener();
    }

    @Bean
    public Job csvToDBJob(){
        return jobBuilderFactory.get("csvToDB")
                .start(csvToDBStep())
                .incrementer(new RunIdIncrementer()) //保证可以多次执行
                .listener(csvToDBJobListener())
                .build();

    }
}
