package com.example.person.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PhoneDTO {
private Long id;
    @Enumerated(EnumType.STRING)
    private String type;
    @NotEmpty
    @Size(min=13,max=14)
    private String number;
}
