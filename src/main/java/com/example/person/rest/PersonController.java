package com.example.person.rest;

import com.example.person.core.PersonNotFoundException;
import com.example.person.domain.Person;
import com.example.person.domain.dto.MensageDTO;
import com.example.person.domain.dto.PersonDTO;
import com.example.person.service.PersonService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private final PersonService personService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public ResponseEntity<MensageDTO> insert(@RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.ok(personService.insert(personDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable() Long id) throws PersonNotFoundException {
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> findByAll() {
        return ResponseEntity.ok(personService.findByAll());
    }

    @PutMapping
    public ResponseEntity<MensageDTO> update(@RequestBody @Valid PersonDTO personDTO) {
        return ResponseEntity.ok(personService.uptade(personDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable() Long id) {
        personService.deleteById(id);
        return ResponseEntity.ok("Deletado");
    }

}
