package com.dio.crudperson.controller;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dio.crudperson.dto.request.PersonRequestDto;
import com.dio.crudperson.entities.Person;
import com.dio.crudperson.services.PersonService;
import com.dio.crudperson.utils.PhoneUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	@Autowired MockMvc mvc;
	@MockBean PersonService personService;
	
	static final String URL_API = "/api/v1/people";
	
	@Test
	@DisplayName("Deve salvar uma pessoa")
	public void savePersonTest() throws Exception {
		
		PersonRequestDto dto = PersonRequestDto.builder().firstName("Hugo")
			 	 										 .lastName("Luiz")
			 	 										 .birthDate(LocalDate.of(1991, 3, 14))
			 	 										 .cpf("98261347087")
			 	 										 .phones(Collections.singleton(PhoneUtil.createFakeDTO()))
			 	 										 .build();
		
		Person savePerson = Person.builder().id(null)
											.firstName("Hugo")
											.lastName("Luiz")
											.birthDate(LocalDate.of(1991, 3, 14))
											.cpf("98261347087")
											.phones(Collections.singleton(PhoneUtil.createFakeDTO()))
											.build();
		
		BDDMockito.given(personService.save(Mockito.any(Person.class))).willReturn(savePerson);
								
		
		String json = new ObjectMapper().writeValueAsString(dto);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
												.post(URL_API)
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.content(json);
		
		mvc
			.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("id").isNotEmpty())
			.andExpect(MockMvcResultMatchers.jsonPath("firstName").value(dto.getFirstName()))
			.andExpect(MockMvcResultMatchers.jsonPath("lastName").value(dto.getLastName()))
			.andExpect(MockMvcResultMatchers.jsonPath("birthDate").value(dto.getBirthDate()))
			.andExpect(MockMvcResultMatchers.jsonPath("cpf").value(dto.getCpf()))
			.andExpect(MockMvcResultMatchers.jsonPath("phones").value(Collections.singleton(PhoneUtil.createFakeDTO())));
	}

}
