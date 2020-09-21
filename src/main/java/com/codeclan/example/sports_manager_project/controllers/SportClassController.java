package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.CountryClass;
import com.codeclan.example.sports_manager_project.models.SportClass;
import com.codeclan.example.sports_manager_project.repositories.CountryClassRepository;
import com.codeclan.example.sports_manager_project.repositories.SportClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportClassController {

    @Autowired
    SportClassRepository sportClassRepository;

    @GetMapping(value = "/sports")
    public ResponseEntity<List<SportClass>> getAllSports() {
        return new ResponseEntity<>(sportClassRepository.findAll(), HttpStatus.OK);
    }
}
