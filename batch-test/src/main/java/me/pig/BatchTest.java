package me.pig;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class BatchTest {

    public static void main(String[] args) {
        SpringApplication.run(BatchTest.class, args);
    }
}