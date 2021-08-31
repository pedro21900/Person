package com.example.person.service;

import com.example.person.core.PersonNotFoundException;
import com.example.person.domain.Person;
import com.example.person.domain.PersonMapper;
import com.example.person.domain.dto.MensageDTO;
import com.example.person.domain.dto.PersonDTO;
import com.example.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    private MensageDTO createMessageResponse(Long id, String message) {
        return MensageDTO
                .builder()
                .mensage(message + id)
                .build();
    }

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MensageDTO insert(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person salved = personRepository.save(personToSave);
        return createMessageResponse(salved.getId(), "Created person with ID :");
    }

    public PersonDTO findById(Long id) throws  PersonNotFoundException{
       Person person=personRepository
                .findById(id)
                .orElseThrow(()-> new PersonNotFoundException(id));

        return personMapper.toDTO(person);
    }

    public List<PersonDTO> findByAll() {
        return personRepository
                .findAll()
                .stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) throws  PersonNotFoundException{
        findById(id);
        personRepository.deleteById(id);
    }

    public MensageDTO uptade(PersonDTO personDTO) {
        Person personToSave = personMapper.toModel(personDTO);
        Person salved = personRepository.save(personToSave);
        return createMessageResponse(salved.getId(), "Update person with ID :");
    }
}
