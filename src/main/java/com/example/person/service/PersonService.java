package com.example.person.service;

import com.example.person.domain.Person;
import com.example.person.domain.dto.MensageDTO;
import com.example.person.repository.PersonRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Service
public class PersonService {

    private final PersonRepository personRepository;

    public MensageDTO insert(Person person) {
        Person ps =personRepository.save(person);
        return MensageDTO
                .builder()
                .mensage("Create person with ID: "+ps.getId() )
                .build();
    }

    public Person findById(Long id) {
        return personRepository.getById(id);
    }
    public List<Person> findByAll() {
        return personRepository.findAll();
    }

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }

    public MensageDTO uptade(Person person) {
        Person ps =personRepository.save(person);
        return MensageDTO
                .builder()
                .mensage("Update person with ID: "+ps.getId() )
                .build();
    }
}
