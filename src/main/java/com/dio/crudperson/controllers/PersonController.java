package com.dio.crudperson.controllers;


import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dio.crudperson.dto.request.PersonRequestDto;
import com.dio.crudperson.dto.response.PersonResponseDto;
import com.dio.crudperson.entities.Person;
import com.dio.crudperson.services.PersonService;
import com.dio.crudperson.services.pagemodel.PageModel;
import com.dio.crudperson.services.pagemodel.PagePersonModel;


@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService personService;
	private ModelMapper modelMapper;
	
	
	public PersonController(PersonService personService, ModelMapper modelMapper) {
		this.personService = personService;
		this.modelMapper = modelMapper;
		
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> findById(@PathVariable Long id){
		Person result = personService.findById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<PageModel<Person>> listAllByOnLazyModel(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		
		PagePersonModel pr = new PagePersonModel(page, size);
		
		PageModel<Person> pm = personService.listAllByOnLazyModel(pr);
		
		return ResponseEntity.ok().body(pm);
	}
	
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> save(@Valid @RequestBody PersonRequestDto requestDto){
		Person entity = modelMapper.map(requestDto, Person.class);
		Person savePerson = personService.save(entity);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(modelMapper.map(savePerson, PersonResponseDto.class));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> update(@Valid @RequestBody PersonRequestDto requestDto, @PathVariable Long id){
		Person updatePerson = modelMapper.map(requestDto, Person.class);
		updatePerson.setId(id);
		
		return ResponseEntity.ok().body(modelMapper.map(updatePerson, PersonResponseDto.class));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		personService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
