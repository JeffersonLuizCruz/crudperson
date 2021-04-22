package com.dio.crudperson.services.pagemodel;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PageModel<E> implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int totalElements; 
	private int pageSize; 
	private int totalPages; 
	private List<E> elements;
}