package com.dio.crudperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dio.crudperson.entities.Phone;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long>{

}
