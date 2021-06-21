package com.example.testaurelien.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.testaurelien.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long>{

}
