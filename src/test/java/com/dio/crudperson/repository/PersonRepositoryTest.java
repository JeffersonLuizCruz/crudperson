package com.dio.crudperson.repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.repositories.PersonRepository;

@SpringBootTest
public class PersonRepositoryTest {
	
	@Autowired PersonRepository personRepository;

	@Test
	public void saveTest() {
		Person person = Person.builder().firstName("Hugo").lastName("Luiz").birthDate(LocalDate.of(1991, 3, 14)).cpf("98261347087").build();
		
		Person createPerson = personRepository.save(person);
		
		Assertions.assertThat(createPerson.getId()).isEqualTo(1L);
	}
	
	@Test
	public void updateTest() {
		
		Person person = Person.builder().firstName("Jefferson").lastName("Luiz").birthDate(LocalDate.of(1991, 3, 14)).cpf("98261347087").build();
		
		Person updatePerson = personRepository.save(person);
		
		Assertions.assertThat(updatePerson.getCpf()).isEqualTo("98261347087");
	}
	
	@Test
	public void getByIdTest() {
		
		Optional<Person> result = personRepository.findById(1L);
		Person person = result.get(); 
		
		Assertions.assertThat(person.getCpf()).isEqualTo("98261347087");
	}
	
	@Test
	public void listTest() {
		
		List<Person> person = personRepository.findAll();
		
		Assertions.assertThat(person.size()).isEqualTo(1L);
	}
	

}
