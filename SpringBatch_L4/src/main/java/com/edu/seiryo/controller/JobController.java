package com.edu.seiryo.controller;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.seiryo.service.IEmployeeService;

@RestController
public class JobController {
	@Autowired
    private IEmployeeService employeeService;

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private JobExplorer jobExplorer;
    @Autowired
    @Qualifier("csvToDBJob")
    private Job csvToDBJob;
    @GetMapping("/csvToDB")
    public String csvToDB() throws Exception {
        employeeService.truncateTemp(); //清空数据运行多次执行
        
        //需要多次执行，run.id 必须重写之前，再重构一个新的参数对象
        JobParameters jobParameters = new JobParametersBuilder(new JobParameters(),jobExplorer)
                .addLong("time", new Date().getTime())
                .getNextJobParameters(csvToDBJob).toJobParameters();
        JobExecution run = jobLauncher.run(csvToDBJob, jobParameters);
        return run.getId().toString();
    }
}
