package com.example.person.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PersonDTO {

    private Long id;
    @NotNull
    @Size(min = 2, max = 100)
    private String fistName;
    @NotNull
    @Size(min = 2, max = 100)
    private String lastName;
    @CPF
    @NotNull
    private String cpf;

    private String birthDate;

    @Valid
    @NotNull
    private List<PhoneDTO> phoneList;

}
