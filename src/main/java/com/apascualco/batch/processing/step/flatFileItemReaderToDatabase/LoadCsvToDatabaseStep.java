package com.apascualco.batch.processing.step.flatFileItemReaderToDatabase;

import com.apascualco.batch.processing.step.CustomStep;
import com.apascualco.persistence.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component("loadCsvToDatabaseStep")
public class LoadCsvToDatabaseStep implements CustomStep {

    private final FlatFileItemReader<Person> reader;
    private final ItemProcessor<Person, Person> processor;
    private final ItemWriter<Person> writer;

    public LoadCsvToDatabaseStep(
            @Named("loadCsvToDatabaseReader") FlatFileItemReader<Person> reader,
            @Named("loadCsvToDatabaseProcessor") ItemProcessor<Person, Person> processor,
            @Named("loadCsvToDatabaseWriter") ItemWriter<Person> writer
    ) {
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Override
    public Step step(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("loadCsvToDatabase-step")
                .allowStartIfComplete(true)
                .<Person, Person>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
