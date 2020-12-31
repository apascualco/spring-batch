package com.apascualco.job;

import com.apascualco.SpringBatchIntegration;
import com.apascualco.persistence.repository.PersonRepository;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import org.junit.Test;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.test.JobLauncherTestUtils;

import javax.inject.Inject;
import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

public class LoadCsvToDatabaseJobIT extends SpringBatchIntegration {

    @Inject private JobLauncherTestUtils jobLauncherTestUtils;
    @Inject private PersonRepository personRepository;

    @Test
    @ExpectedDatabase(value= "/dataset/defaultdb.xml", assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void load_csv_to_database_job_test() {
        validateBatchExecution(jobLauncherTestUtils.launchStep("loadCsvToDatabase-step"));
    }

    private void validateBatchExecution(final JobExecution jobExecution) {
        assertEquals("ExistStatus should be COMPLETED", ExitStatus.COMPLETED, jobExecution.getExitStatus());
        assertNotNull("StepExecutions mustn't be null",jobExecution.getStepExecutions());
        Iterator<StepExecution> stepExecutionIterator = jobExecution.getStepExecutions().iterator();
        assertNotNull("Iterator StepExecution mustn't be null",stepExecutionIterator);
        final StepExecution stepExecution = stepExecutionIterator.next();
        assertNotNull("StepExecution mustn't be null",stepExecution);

        assertEquals("Batch must have read 6",6,stepExecution.getReadCount());
        assertEquals("Batch must have write 6",6,stepExecution.getWriteCount());
        assertEquals("Batch must have do 2 commits",2,stepExecution.getCommitCount());
    }

}
