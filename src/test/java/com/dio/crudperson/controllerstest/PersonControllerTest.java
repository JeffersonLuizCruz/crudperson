package com.dio.crudperson.controllerstest;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dio.crudperson.dto.request.PersonRequestDto;
import com.dio.crudperson.utils.PhoneUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@WebMvcTest
@AutoConfigureMockMvc
public class PersonControllerTest {
	
	static final String URL_API = "/api/v1/peaple";
	
	@Autowired
	MockMvc mvc;
	
	@Test
	@DisplayName("Deve salvar uma pessoa")
	public void savePersonTest() throws Exception {
		
		PersonRequestDto dto = PersonRequestDto.builder()
													 .firstName("Jefferson Luiz")
													 .lastName("Cruz")
													 .birthDate(LocalDate.of(1991, 3, 14))
													 .cpf("00044587777720")
													 .phones(Collections.singleton(PhoneUtil.createFakeDTO()))
													 .build();
		
		String json = new ObjectMapper().writeValueAsString(dto);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
												.post(URL_API)
												.contentType(MediaType.APPLICATION_JSON)
												.accept(MediaType.APPLICATION_JSON)
												.content(json);
		
		mvc
			.perform(request)
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("firstName").value(dto.getFirstName()))
			.andExpect(MockMvcResultMatchers.jsonPath("lastName").value(dto.getLastName()))
			.andExpect(MockMvcResultMatchers.jsonPath("birthDate").value(dto.getBirthDate()))
			.andExpect(MockMvcResultMatchers.jsonPath("cpf").value(dto.getCpf()))
			.andExpect(MockMvcResultMatchers.jsonPath("phones").value(dto.getPhones()));
	}

}
