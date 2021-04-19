package com.dio.crudperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.crudperson.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Person findByCpf(Long id);

}
