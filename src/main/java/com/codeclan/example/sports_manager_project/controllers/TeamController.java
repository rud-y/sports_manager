package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Team;
import com.codeclan.example.sports_manager_project.models.Team;
import com.codeclan.example.sports_manager_project.models.Venue;
import com.codeclan.example.sports_manager_project.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    @Autowired
    TeamRepository teamRepository;

    @GetMapping(value = "/teams")
    public ResponseEntity<List<Team>> getAllTeams(
            @RequestParam(name= "venue", required = false) Venue venue) {
        if(venue != null) {
            return new ResponseEntity<>(teamRepository.findByVenue(venue), HttpStatus.OK);
        }

        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/teams/{id}")
    public ResponseEntity getTeam(@PathVariable Long id) {
        return new ResponseEntity<>(teamRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/teams")
    public ResponseEntity<Team> postTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }
    @PutMapping(value = "/teams/{id}")
    public ResponseEntity<Team> updateTeam(@RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.OK);
    }

    @DeleteMapping(value = "/teams/{id}")
    public ResponseEntity<List<Team>> deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

}
