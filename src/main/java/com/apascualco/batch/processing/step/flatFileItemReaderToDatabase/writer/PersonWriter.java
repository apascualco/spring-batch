package com.apascualco.batch.processing.step.flatFileItemReaderToDatabase.writer;

import com.apascualco.persistence.model.Person;
import com.apascualco.persistence.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@AllArgsConstructor
@Component("loadCsvToDatabaseWriter")
public class PersonWriter implements ItemWriter<Person> {

    private PersonRepository personRepository;

    @Override
    public void write(List<? extends Person> persons) {
        persons.stream().map(Person::toString).forEach(log::info);
        personRepository.saveAll(persons);
    }
}
