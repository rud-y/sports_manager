package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Country;
import com.codeclan.example.sports_manager_project.models.Person;
import com.codeclan.example.sports_manager_project.repositories.PersonRepository;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping(value = "/people")
    public ResponseEntity<List<Person>> getAllPlayers(
            @RequestParam(name = "nationality", required = false) String nationality) {
        if(nationality != null){
            return new ResponseEntity<>(personRepository.findByNationality(nationality), HttpStatus.OK);
        }
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/people/{id}")
    public ResponseEntity getPlayer(@PathVariable Long id) {
        return new ResponseEntity<>(personRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/people")
    public ResponseEntity<Person> postPerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
    @PutMapping(value = "/people/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping(value = "/people/{id}")
    public ResponseEntity<List<Person>> deletePerson(@PathVariable Long id) {
        personRepository.deleteById(id);
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }



}
