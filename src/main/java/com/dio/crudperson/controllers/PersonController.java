package com.dio.crudperson.controllers;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.dio.crudperson.services.PersonServiceImpl;
import com.dio.crudperson.services.pagemodel.PageModel;
import com.dio.crudperson.services.pagemodel.PagePersonModel;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	@Autowired private PersonServiceImpl personService;
	
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) throws NotFoundException {
		Person result = personService.findById(id);
		return ResponseEntity.ok(result);
	}
	
	/**********************
	 * 
	 *  Upgrade listAll() to listAllByOnLazyMode
	 *  
	@GetMapping
	public ResponseEntity<List<PersonResponseDto>> listAll() {
		List<Person> list = personService.listAll();
		List<PersonResponseDto> listDto = list
											.stream()
											.map(result -> new PersonResponseDto(result))
											.collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listDto);
	}
	
	********************/
	
	@GetMapping
	public ResponseEntity<PageModel<Person>> listAllByOnLazyModel(
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size){
		
		PagePersonModel pr = new PagePersonModel(page, size);
		
		PageModel<Person> pm = personService.listAllByOnLazyModel(pr);
		
		return ResponseEntity.ok(pm);
	}
	
	
	@PostMapping
	public ResponseEntity<PersonResponseDto> save(@Valid @RequestBody PersonRequestDto requestDto){
		Person savePerson = personService.save(requestDto.transformToDto());
		
		return ResponseEntity.ok().body(new PersonResponseDto(savePerson));
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonResponseDto> update(@Valid @RequestBody PersonRequestDto requestDto, @PathVariable Long id){
		Person updatePerson = requestDto.transformToDto();
		updatePerson.setId(id);
		
		return ResponseEntity.ok().body(new PersonResponseDto(updatePerson));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws NotFoundException {
		personService.delete(id);
		
		return ResponseEntity.noContent().build();
	}

}
