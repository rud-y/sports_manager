package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Sport;
import com.codeclan.example.sports_manager_project.repositories.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SportClassController {

    @Autowired
    SportRepository sportRepository;

    @GetMapping(value = "/sports")
    public ResponseEntity<List<Sport>> getAllSports() {
        return new ResponseEntity<>(sportRepository.findAll(), HttpStatus.OK);
    }
}
