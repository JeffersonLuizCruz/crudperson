package com.dio.crudperson.controllers.exceptions;

import java.time.OffsetDateTime;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class ApiErrorList extends ApiError{
	private static final long serialVersionUID = 1L;

	private List<String> erros;

	public ApiErrorList(Integer code, String message, OffsetDateTime date, List<String> erros) {
		super(code, message, date);
		this.erros = erros;
	}
	
	
}
