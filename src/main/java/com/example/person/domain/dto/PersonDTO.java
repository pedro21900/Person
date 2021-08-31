package com.example.person.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String fistName;

    private String lastName;

    private String cpf;

    private LocalDate birthDate;

    private List<PhoneDTO> phoneList;

}
