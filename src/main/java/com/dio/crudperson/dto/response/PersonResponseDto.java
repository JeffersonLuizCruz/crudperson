package com.dio.crudperson.dto.response;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.dio.crudperson.entities.Person;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter @Setter
public class PersonResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório - Nome")
    @Size(min = 2, max = 100)
	private String firstName;
	
	@NotEmpty(message = "Preenchimento obrigatório - Sobrenome")
    @Size(min = 2, max = 100)
	private String lastName;
	
	@NotEmpty(message = "Preenchimento obrigatório - CPF")
    @CPF
	private String cpf;
	
	@NotEmpty(message = "Preenchimento obrigatório - Data de Nascimento")
    @Size(min = 2, max = 100)
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthDate;
	
	
	public PersonResponseDto(Person person) {
		this.firstName = person.getFirstName();
		this.lastName = person.getLastName();
		this.birthDate = person.getBirthDate();
	}
}
