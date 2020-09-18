package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Tournament;
import com.codeclan.example.sports_manager_project.repositories.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping(value = "/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments () {
        return new ResponseEntity<>(tournamentRepository.findAll(), HttpStatus.OK);
    }

}
