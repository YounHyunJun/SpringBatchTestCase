package jun;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.config.AbstractTestConfiguration;

import static jun.ExampleBatchTest.TestConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class ExampleBatchTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job flowJob;

    @Test
    public void executeBatch() throws Exception {
        jobLauncher.run(flowJob, new JobParameters());
    }

    @ComponentScan(basePackages = {
            "jun.springExample.config"
    })
    @Configuration
    static class TestConfiguration extends AbstractTestConfiguration {}

}
