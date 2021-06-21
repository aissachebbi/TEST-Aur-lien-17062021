package com.example.testaurelien.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.testaurelien.model.Person;
import com.example.testaurelien.repository.PersonRepository;
import com.example.testaurelien.service.PersonService;
import com.google.common.collect.Lists;

@Service
public class PersonServiceImpl implements PersonService {

	private static final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<List<Person>> subList(List<Person> persons, int subListSize) {
		List<Person> invalidsPersons = persons.stream()
				.filter(p -> p.getFirstName() == null || p.getFirstName().equals("")
				|| p.getLastName() == null || p.getLastName().equals(""))
				.collect(Collectors.toList());
		if (LOG.isDebugEnabled()) {
			LOG.debug("The following persons are not valid :");
		}
		for (Person invalidPerson : invalidsPersons) {
			if (LOG.isDebugEnabled()) {
				LOG.debug("first name : {}, last name : {}", invalidPerson.getFirstName(), invalidPerson.getLastName());
			}
		}
		List<Person> validsPersons = persons.stream()
				.filter(p -> p.getFirstName() != null && !p.getFirstName().equals("")
				&& p.getLastName() != null && !p.getLastName().equals(""))
				.collect(Collectors.toList());
		return Lists.partition(validsPersons, subListSize);
	}


	@Override
	public void savePersonsMoreThan40(List<Person> persons) {
		List<Person> filteredPersons = persons.stream()
				.filter(p -> p.getAge() > 40)
				.collect(Collectors.toList());
		for (Person filteredPerson : filteredPersons) {
			personRepository.save(filteredPerson);
		}
	}
	
}
