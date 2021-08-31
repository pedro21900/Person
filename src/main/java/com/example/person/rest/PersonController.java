package com.example.person.rest;

import com.example.person.domain.Person;
import com.example.person.domain.dto.MensageDTO;
import com.example.person.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class PersonController {
    private final PersonService personService;
    @PostMapping
    public ResponseEntity<MensageDTO> insert(@RequestBody Person person){
        return ResponseEntity.ok(personService.insert(person));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Person> findById(Long id){
        return ResponseEntity.ok(personService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<Person>> findByAll(){
        return ResponseEntity.ok(personService.findByAll());
    }
    @PutMapping
    public ResponseEntity<MensageDTO> update(@RequestBody Person person){
        return ResponseEntity.ok(personService.uptade(person));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(Long id){
        personService.deleteById(id);
        return ResponseEntity.ok("Deletado");
    }

}
