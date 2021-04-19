package com.dio.crudperson.entities;

import java.io.Serializable;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.dio.crudperson.entities.enums.PhoneType;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Phone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String number;
	
	@Enumerated(EnumType.STRING)
	private PhoneType type;

}
