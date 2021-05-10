package com.dio.crudperson.dto.response;

import java.io.Serializable;

import com.dio.crudperson.entities.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class PhoneResponseDto implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String number;
	private PhoneType type;

}
