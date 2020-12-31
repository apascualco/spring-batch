package com.apascualco.persistence.repository;

import com.apascualco.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository  extends JpaRepository<Person, Long>, BaseRepository {
}