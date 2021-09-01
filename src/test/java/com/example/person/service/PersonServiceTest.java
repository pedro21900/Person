package com.example.person.service;

import com.example.person.domain.Person;
import com.example.person.domain.dto.MensageDTO;
import com.example.person.domain.dto.PersonDTO;
import com.example.person.repository.PersonRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.example.person.utils.PersonUtils.createFakeDTO;
import static com.example.person.utils.PersonUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO personDTO = createFakeDTO();
        Person expectedSavedPerson = createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavedPerson);

        MensageDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPerson.getId());
        MensageDTO succesMessage = personService.insert(personDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MensageDTO createExpectedMessageResponse(Long id) {
        return MensageDTO
                .builder()
                .mensage("Created person with ID " + id)
                .build();
    }
}
