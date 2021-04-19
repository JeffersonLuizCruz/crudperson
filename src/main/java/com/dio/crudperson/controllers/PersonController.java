package com.dio.crudperson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.services.PersonServiceImpl;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private final PersonServiceImpl personService;
	
	@Autowired
	public PersonController(PersonServiceImpl personService) {
		this.personService = personService;
	}
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) throws NotFoundException {
		Person result = personService.findById(id);
		return ResponseEntity.ok(result);
	}
	
	

}
