package com.dio.crudperson.services;

import java.util.List;

import com.dio.crudperson.entities.Person;
import com.dio.crudperson.services.pagemodel.PageModel;
import com.dio.crudperson.services.pagemodel.PagePersonModel;


public interface PersonService {
	
	Person findById(Long id);
	List<Person> listAll();
	PageModel<Person> listAllByOnLazyModel(PagePersonModel pr);
	Person save(Person person);
	Person update(Person person);
	void delete(Long id);

}
