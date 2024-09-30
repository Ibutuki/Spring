package com.edu.seiryo;

import org.junit.jupiter.api.Test;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = App.class)
public class StartJobTest {
	 @Autowired
	    private JobLauncher jobLauncher;
	    @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;
	    public Tasklet tasklet11(){
	        return new Tasklet() {
	            @Override
	            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
	                System.out.println("Hello SpringBatch....");
	                return RepeatStatus.FINISHED;
	            }
	        };
	    }
	    public Step step11() {
	    	TaskletStep step11 = stepBuilderFactory.get("step11")
	    			.tasklet(tasklet11())
	    			.bulid();
	    	return step11;
	    }
	    public Job job11() {
	    	Job job = jobBuilderFactory.get("job11")
	    	.start(step11())
	    	.bulid();
	    	return job;
	    }
	    @Test
	    public void testStart() throws Exception{
	    	JobLauncher.run(job(), new JobParameters());
	    }
}
