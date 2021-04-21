package com.dio.crudperson.controllers.exceptions;

import java.io.Serializable;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ApiError implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer code;
	private String message;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private OffsetDateTime date;

}