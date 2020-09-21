package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.CountryClass;
import com.codeclan.example.sports_manager_project.models.Venue;
import com.codeclan.example.sports_manager_project.repositories.CountryClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryClassController {

    @Autowired
    CountryClassRepository countryClassRepository;

    @GetMapping(value = "/countries")
    public ResponseEntity<List<CountryClass>> getAllCountries() {
        return new ResponseEntity<>(countryClassRepository.findAll(), HttpStatus.OK);
    }
}
