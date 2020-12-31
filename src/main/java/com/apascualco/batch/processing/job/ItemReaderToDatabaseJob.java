package com.apascualco.batch.processing.job;

import com.apascualco.batch.processing.step.CustomStep;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Slf4j
@Component
@Configuration
public class ItemReaderToDatabaseJob {

    private final CustomStep customStep;

    public ItemReaderToDatabaseJob(
            @Named("itemReaderToDatabaseStep") final CustomStep customStep
    ) {
        this.customStep = customStep;
    }

    @Bean(name = "beanItemReaderToDatabaseJob")
    public Job job(final JobBuilderFactory jobBuilderFactory, final StepBuilderFactory stepBuilderFactory) {

        return jobBuilderFactory.get("itemReaderToDatabase-job")
                .start(customStep.step(stepBuilderFactory))
                .build();
    }
}
