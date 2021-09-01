package com.example.person.utils;

import com.example.person.domain.Phone;
import com.example.person.domain.dto.PhoneDTO;

public class PhoneUtils {

    private static final String PHONE_NUMBER = "1199999-9999";
    private static final String PHONE_TYPE = "mobile";
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO() {
        return PhoneDTO.builder()
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }

    public static Phone createFakeEntity() {
        return Phone.builder()
                .id(PHONE_ID)
                .number(PHONE_NUMBER)
                .type(PHONE_TYPE)
                .build();
    }
}