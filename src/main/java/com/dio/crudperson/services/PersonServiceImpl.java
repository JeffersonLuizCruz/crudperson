package com.dio.crudperson.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.repositories.PersonRepository;
import com.dio.crudperson.repositories.PhoneRepository;
import com.dio.crudperson.services.crudservice.PersonService;
import com.dio.crudperson.services.execeptions.BadRequestException;
import com.dio.crudperson.services.execeptions.NotFoundException;

@Service
public class PersonServiceImpl implements PersonService{
	
	@Autowired private  PersonRepository personRepository;
	@Autowired private PhoneRepository phoneRepository;
	

	@Override
	public Person findById(Long id) {
		
		return verifyIfExist(id);
	}

	@Override
	public List<Person> listAll() {
		List<Person> list = personRepository.findAll();
		
		return list;
	}

	@Transactional
	@Override
	public Person save(Person person) {
		person.setId(null);
		Person verifyIfExist = personRepository.findByCpf(person.getCpf());
		
		if(verifyIfExist != null && !verifyIfExist.equals(person)) {
			throw new BadRequestException("Usuário com CPF cadastrado no sistema " + person.getCpf());
		}
		
		Person savePerson = personRepository.save(person);
		phoneRepository.saveAll(savePerson.getPhones());
		
		
		return savePerson;
	}

	@Transactional
	@Override
	public Person update(Person person) {
		Person updatePerson = verifyIfExist(person.getId());
		
		return updatePerson;
	}

	@Override
	public void delete(Long id) {
		Person deletePerson = verifyIfExist(id);
		personRepository.delete(deletePerson);
		
	}
	
	private Person verifyIfExist(Long id) {
		Optional<Person> result = personRepository.findById(id);
		result.orElseThrow(() ->  new NotFoundException("Não existe usuário com id: " + id ));
		
		return result.get();
	}

}
