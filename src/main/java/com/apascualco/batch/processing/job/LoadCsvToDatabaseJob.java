package com.apascualco.batch.processing.job;

import com.apascualco.batch.processing.step.CustomStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Slf4j
@Component
@Configuration
public class LoadCsvToDatabaseJob {

    private final CustomStep loadCsvToDatabase;

    public LoadCsvToDatabaseJob(
            @Named("loadCsvToDatabaseStep") final CustomStep loadCsvToDatabase
    ) {
        this.loadCsvToDatabase = loadCsvToDatabase;
    }

    @Primary
    @Bean(name = "beanLoadCsvToDatabaseJob")
    public Job job(final JobBuilderFactory jobBuilderFactory, final StepBuilderFactory stepBuilderFactory) {

        return jobBuilderFactory.get("loadCsvToDatabase-job")
                .start(loadCsvToDatabase.step(stepBuilderFactory))
                .build();
    }
}
