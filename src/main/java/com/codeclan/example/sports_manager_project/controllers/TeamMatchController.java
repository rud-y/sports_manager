package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.TeamMatch;
import com.codeclan.example.sports_manager_project.repositories.TeamMatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamMatchController {

    @Autowired
    TeamMatchRepository teamMatchRepository;

    @GetMapping(value = "/team_matches")
    public ResponseEntity<List<TeamMatch>> getAllTeamMatches() {
        return new ResponseEntity<>(teamMatchRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/team_matches/{id}")
    public ResponseEntity getTeamMatch(@PathVariable Long id){
        return new ResponseEntity<>(teamMatchRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/team_matches")
    public ResponseEntity<TeamMatch> postTeamMatch(@RequestBody TeamMatch customer){
        teamMatchRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value="/team_matches/{id}")
    public ResponseEntity<TeamMatch> updateTeamMatch(@RequestBody TeamMatch customer) {
        teamMatchRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

    @DeleteMapping(value="/team_matches/{id}")
    public ResponseEntity<List<TeamMatch>> deleteTeamMatch(@PathVariable Long id) {
        teamMatchRepository.deleteById(id);
        return new ResponseEntity<>(teamMatchRepository.findAll(), HttpStatus.OK);
    }
}
