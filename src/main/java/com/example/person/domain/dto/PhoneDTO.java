package com.example.person.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PhoneDTO {

    private Long id;

    private String type;

    private String number;
}
