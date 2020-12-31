package com.apascualco.batch.processing.step.itemReaderToDatabase.reader;

import com.apascualco.persistence.model.Person;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("itemReaderToDatabaseReader")
public class ItemReaderToDatabaseReader implements ItemReader<Person> {

    private final IteratorItemReader<Person> iteratorItemReader;

    public ItemReaderToDatabaseReader() {
        final List<Person> personList = new ArrayList<>();
        final Person paco = new Person();
        paco.setName("Paco");
        paco.setLastName("Pill");
        paco.setEmail("zpaco@gmail.com");
        personList.add(paco);
        final Person roberto = new Person();
        roberto.setName("Roberto");
        roberto.setLastName("Lorna");
        roberto.setEmail("roberto@gmail.com");
        personList.add(roberto);
        final Person agustin = new Person();
        agustin.setName("Agustin");
        agustin.setLastName("Perez");
        agustin.setEmail("aperez@gmail.com");
        personList.add(agustin);
        final Person sonia = new Person();
        sonia.setName("Sonia");
        sonia.setLastName("Role");
        sonia.setEmail("roso@gmail.com");
        personList.add(sonia);
        final Person eva = new Person();
        eva.setName("Eva");
        eva.setLastName("Ortega");
        eva.setEmail("oretegaeva@gmail.com");
        personList.add(eva);
        final Person ortega = new Person();
        ortega.setName("Ortega");
        ortega.setLastName("lupo");
        ortega.setEmail("oretelupo@gmail.com");
        personList.add(ortega);
        this.iteratorItemReader = new IteratorItemReader<>(personList);
    }

    @Override
    public Person read() {
        return iteratorItemReader.read();
    }
}
