package com.dio.crudperson.services.pagemodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class PagePersonModel {

	private int page; 
	private int size;

}
