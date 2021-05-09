package com.dio.crudperson.dto.response;

import com.dio.crudperson.entities.enums.PhoneType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class PhoneResponseDto {
	
	private Long id;
	private String number;
	private PhoneType type;

}
