package me.pig.batch.step;

import me.pig.batch.common.AbstractJobManager;
import me.pig.config.BatchConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles(profiles = "test")
@SpringBootTest
@SpringBatchTest
class CoffeeStepTest extends AbstractJobManager {

    @Autowired
    private BatchConfiguration batchConfiguration;

    @BeforeEach
    void setUp() {
        jobLauncherTestUtils = new JobLauncherTestUtils();
        jobLauncherTestUtils.setJob(batchConfiguration.testJob());
        jobLauncherTestUtils.setJobLauncher(jobLauncher);
        jobLauncherTestUtils.setJobRepository(jobRepository);
    }

    @Test
    void test() {
        // given
        LocalDate monday = LocalDate.of(2022, 11, 21);
        LocalDateTime monday9Hours30Minutes = monday.atStartOfDay().plusHours(9).plusMinutes(30);

        JobParameters parameters = new JobParametersBuilder()
                .addString("createTime", FULL_DATE_TIME_FORMATTER.format(monday9Hours30Minutes))
                .toJobParameters();

        // when
        String stepName = "testStep";
        JobExecution jobExecution = jobLauncherTestUtils.launchStep(stepName, parameters);

        // then
        assertThat(jobExecution.getStatus()).isEqualTo(BatchStatus.COMPLETED);
    }
}