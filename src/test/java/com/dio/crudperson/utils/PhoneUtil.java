package com.dio.crudperson.utils;

import com.dio.crudperson.entities.Phone;
import com.dio.crudperson.entities.enums.PhoneType;

public class PhoneUtil {
	
    private static final String PHONE_NUMBER = "00044587777720";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;

    public static Phone createFakeDTO() {
        return Phone.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }


}
