package com.dio.crudperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.repositories.PersonRepository;
import com.dio.crudperson.services.crudservice.PersonService;
import com.dio.crudperson.services.execeptions.BadRequestException;

import javassist.NotFoundException;

public class PersonServiceImpl implements PersonService{
	
	private final PersonRepository personRepository;
	
	@Autowired
	 public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public Person findById(Long id) throws NotFoundException {
		
		return verifyIfExist(id);
	}

	@Override
	public List<Person> listAll() {
		List<Person> list = personRepository.findAll();
		
		return list;
	}

	@Override
	public Person save(Person person) {
		person.setId(null);
		
		try {
			personRepository.findByCpf(person.getId());
		} catch (Exception e) {
			throw new BadRequestException("Usuário com esse CPF já existe!: " + person.getCpf());
		}
		
		Person savePerson = personRepository.save(person);
		
		return savePerson;
	}

	@Override
	public Person update(Person person) throws NotFoundException {
		Person updatePerson = verifyIfExist(person.getId());
		
		return updatePerson;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		Person deletePerson = verifyIfExist(id);
		personRepository.delete(deletePerson);
		
	}
	
	private Person verifyIfExist(Long id) throws NotFoundException {
		Optional<Person> result = personRepository.findById(id);
		result.orElseThrow(() -> new NotFoundException("Não existe usuário com id: " + id + " Tipo: " + Person.class));
		
		return result.get();
	}

}
