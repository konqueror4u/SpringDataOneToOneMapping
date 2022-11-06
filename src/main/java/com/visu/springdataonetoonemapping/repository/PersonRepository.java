package com.visu.springdataonetoonemapping.repository;

import com.visu.springdataonetoonemapping.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
