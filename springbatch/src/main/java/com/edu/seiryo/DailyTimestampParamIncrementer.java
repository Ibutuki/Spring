package com.edu.seiryo;

import java.util.Date;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersIncrementer;

public class DailyTimestampParamIncrementer implements JobParametersIncrementer {
	 @Override
	    public JobParameters getNext(JobParameters parameters) {
	        return new JobParametersBuilder(parameters)
	                .addLong("daily", new Date().getTime())  //添加时间戳
	                .toJobParameters();
	    }
}
