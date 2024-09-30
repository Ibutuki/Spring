package com.edu.seiryo;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

public class JobStateListener 
//implements JobExecutionListener
{
	//1.不使用注解
//	@Override
//	public void beforeJob(JobExecution jobExecution) {
//		System.err.println("执行前-status：" + jobExecution.getStatus());
//	}
//
//	@Override
//	public void afterJob(JobExecution jobExecution) {
//		System.err.println("执行后-status：" + jobExecution.getStatus());
//	}
	 @BeforeJob
	    public void beforeJob(JobExecution jobExecution) {
	        System.err.println("执行前-anno-status：" + jobExecution.getStatus());
	}
	
	@AfterJob
	public void afterJob(JobExecution jobExecution) {
	    System.err.println("执行后-anno-status：" + jobExecution.getStatus());
	}
}
