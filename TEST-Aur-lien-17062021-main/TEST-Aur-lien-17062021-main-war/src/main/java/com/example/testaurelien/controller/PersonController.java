package com.example.testaurelien.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.testaurelien.model.Person;
import com.example.testaurelien.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping(path = "/api/subList", produces = "application/json")
	public List<List<Person>> subList (List<Person> persons, int subListSize) {
		return personService.subList(persons, subListSize);
	}
	
	@PostMapping(path = "/api/savePersonsMoreThan40", produces = "application/json")
	public void savePersonsMoreThan40 (List<Person> persons) {
		personService.savePersonsMoreThan40(persons);
	}
}
