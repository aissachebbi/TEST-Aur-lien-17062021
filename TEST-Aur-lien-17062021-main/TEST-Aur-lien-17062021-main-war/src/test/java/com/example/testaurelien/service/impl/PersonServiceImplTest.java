package com.example.testaurelien.service.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.testaurelien.model.Person;
import com.example.testaurelien.service.PersonService;
import com.google.common.collect.Lists;

public class PersonServiceImplTest {

	@Test
	public void testSubList() {
		Person p1 = Person.builder().firstName("Marc").lastName("Henry").age(22).build();
		Person p2 = Person.builder().firstName("Jon").lastName("Do").age(18).build();
		Person p3 = Person.builder().firstName("Jean").lastName("Patric").age(49).build();
		Person p4 = Person.builder().firstName("Paul").lastName("Mac").age(52).build();
		Person p5 = Person.builder().firstName("Herve").lastName("Do").age(34).build();
		List<Person> persons = Lists.newArrayList(p1, p2, p3, p4, p5);
		PersonService personService = new PersonServiceImpl();
		List<List<Person>> subLists = personService.subList(persons, 2);
		assertEquals(3, subLists.size());
	}
}
