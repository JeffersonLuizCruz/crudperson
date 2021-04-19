package com.dio.crudperson.services.crudservice;

import java.util.List;

import com.dio.crudperson.entities.Person;

import javassist.NotFoundException;

public interface PersonService {
	
	Person findById(Long id) throws NotFoundException;
	List<Person> listAll();
	Person save(Person person);
	Person update(Person person) throws NotFoundException;
	void delete(Long id) throws NotFoundException;

}
