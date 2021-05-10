package com.dio.crudperson.service;

import java.time.LocalDate;
import java.util.Collections;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.repositories.PersonRepository;
import com.dio.crudperson.repositories.PhoneRepository;
import com.dio.crudperson.services.PersonService;
import com.dio.crudperson.services.impl.PersonServiceImpl;
import com.dio.crudperson.utils.PhoneUtil;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class PersonServiceTest {
	
	PersonService service;
	
	@MockBean PersonRepository personRepository;
	@MockBean PhoneRepository phoneRepository;
	
	@BeforeEach
	public void setSup() {
		this.service = new PersonServiceImpl(personRepository, phoneRepository);
	}
	
	@Test
	@DisplayName("Deve Salvar uma pessoa")
	public void savePersonTest() {
		
		Person person = Person.builder().firstName("Jefferson")
										.lastName("Cruz")
										.birthDate(LocalDate.of(1991, 3, 14))
										.cpf("98261347087")
										.phones(Collections.singleton(PhoneUtil.createFakeDTO()))
										.build();
		Mockito.when(personRepository.save(person)).thenReturn(Person.builder().id(1L)
																	 		   .firstName("Jefferson")
																	 		   .lastName("Cruz")
																	 		   .birthDate(LocalDate.of(1991, 3, 14))
																	 		   .cpf("98261347087")
																	 		   .phones(Collections.singleton(PhoneUtil.createFakeDTO()))
																	 		   .build());
		Person savePerson = personRepository.save(person);
		
		Assertions.assertThat(savePerson.getId()).isNotNull();
		Assertions.assertThat(savePerson.getFirstName()).isEqualTo("Jefferson");
		Assertions.assertThat(savePerson.getLastName()).isEqualTo("Cruz");
		Assertions.assertThat(savePerson.getBirthDate()).isEqualTo(LocalDate.of(1991, 3, 14));
		Assertions.assertThat(savePerson.getCpf()).isEqualTo("98261347087");
		Assertions.assertThat(savePerson.getPhones()).isNotEmpty();
		
																	 		   
	}

}
