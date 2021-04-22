package com.dio.crudperson.repository;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.entities.Phone;
import com.dio.crudperson.entities.enums.PhoneType;
import com.dio.crudperson.repositories.PersonRepository;
import com.dio.crudperson.repositories.PhoneRepository;

@SpringBootTest
public class PersonTest {
	
	@Autowired private PersonRepository personRepository;
	@Autowired private PhoneRepository phoneRepository;
	
	@Test
	public void save() {
		
		Phone phone = new Phone();
		phone.setNumber("988053100");
		phone.setType(PhoneType.COMMERCIAL);
		
		Person person = new Person(null, "Hugo", "Luiz", "08575874470", LocalDate.now());
		person.getPhones().add(phone);
		
		Person savePerson = personRepository.save(person);
		phoneRepository.saveAll(savePerson.getPhones());
	}

}
