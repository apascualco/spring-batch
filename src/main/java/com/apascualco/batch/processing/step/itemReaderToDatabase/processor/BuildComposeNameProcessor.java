package com.apascualco.batch.processing.step.itemReaderToDatabase.processor;

import com.apascualco.persistence.model.Person;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("itemReaderToDatabaseProcessor")
public class BuildComposeNameProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(final Person person) {
        final Person processedPerson = new Person();
        processedPerson.setName(person.getName());
        processedPerson.setLastName(person.getLastName());
        processedPerson.setEmail(person.getEmail());
        processedPerson.setComposeName(person.getLastName() + " " +person.getName());
        processedPerson.setActive(true);
        return processedPerson;
    }

}
