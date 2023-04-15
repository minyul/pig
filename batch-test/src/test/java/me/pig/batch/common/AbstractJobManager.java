package me.pig.batch.common;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public abstract class AbstractJobManager {

    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final DateTimeFormatter FULL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd^HH:mm:ss");

    protected JobLauncherTestUtils jobLauncherTestUtils;

    @Autowired
    protected JobLauncher jobLauncher;

    @Autowired
    protected JobRepository jobRepository;

}
