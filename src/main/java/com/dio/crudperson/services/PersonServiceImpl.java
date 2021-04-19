package com.dio.crudperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.repositories.PersonRepository;
import com.dio.crudperson.services.crudservice.PersonService;

import javassist.NotFoundException;

public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	
	@Autowired
	 public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> listAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person save(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person update(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private Person verifyIfExist(Long id) {
		Optional<Person> result = personRepository.findById(id);
		result.orElseThrow(() -> new NotFoundException("Não existe usuário com id: " + id + " Tipo: " + Person.class));
		
		return result.get();
	}

}
