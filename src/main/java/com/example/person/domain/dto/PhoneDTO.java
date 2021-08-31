package com.example.person.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PhoneDTO {
    private Long id;

    @Enumerated(EnumType.STRING)
    private String type;
    @NotNull
    @Size(min=13,max=14)
    private String number;
}
