package com.edu.seiryo;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;

public class MyStepListener implements StepExecutionListener {

	@Override
	public void beforeStep(StepExecution stepExecution) {
		 System.out.println("-----------beforeStep--------->");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		 System.out.println("-----------afterStep--------->");
	        return stepExecution.getExitStatus();  //不改动返回状态
	}
	
}
