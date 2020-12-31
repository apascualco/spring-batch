package com.apascualco.batch.processing.step.itemReaderToDatabase;

import com.apascualco.batch.processing.step.CustomStep;
import com.apascualco.persistence.model.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Component("itemReaderToDatabaseStep")
public class ItemReaderToDatabaseStep implements CustomStep {

    private final ItemReader<Person> reader;
    private final ItemProcessor<Person, Person> processor;
    private final ItemWriter<Person> writer;

    public ItemReaderToDatabaseStep(
            @Named("itemReaderToDatabaseReader") ItemReader<Person> reader,
            @Named("itemReaderToDatabaseProcessor") ItemProcessor<Person, Person> processor,
            @Named("itemReaderToDatabaseWriter") ItemWriter<Person> writer
    ) {
        this.reader = reader;
        this.processor = processor;
        this.writer = writer;
    }

    @Override
    public Step step(StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("itemReaderToDatabase-step")
                .allowStartIfComplete(true)
                .<Person, Person>chunk(5)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
