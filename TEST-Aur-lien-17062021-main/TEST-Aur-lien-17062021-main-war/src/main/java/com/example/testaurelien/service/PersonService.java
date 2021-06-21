package com.example.testaurelien.service;

import java.util.List;

import com.example.testaurelien.model.Person;

public interface PersonService {

	/**
	 * This service split the persons list in sublist of subListSize maximum
	 * @param persons the persons list to split
	 * @param subListSize the maximum size of the sublists
	 * @return the list of sublists 
	 */
	List<List<Person>> subList(List<Person> persons, int subListSize);
	
	/**
	 * Save in database the person that have more that 40 years old
	 * @param persons the persons to save in database
	 */
	void savePersonsMoreThan40 (List<Person> persons);
	
}
