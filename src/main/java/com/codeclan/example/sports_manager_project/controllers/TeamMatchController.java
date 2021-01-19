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
    public ResponseEntity<List<TeamMatch>> getAllTeamMatches(
            @RequestParam(name = "scorer", required = false) String scorer,
            @RequestParam(name = "completed", required = false) Boolean completed ) {
        if(completed != null) {
            return new ResponseEntity<>(teamMatchRepository.findByCompleted(completed), HttpStatus.OK);
        }
        if(scorer != null) {
            return new ResponseEntity<>(teamMatchRepository.findByScoreEventsPersonLastName(scorer),HttpStatus.OK);
        }
        return new ResponseEntity<>(teamMatchRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/team_matches/{id}")
    public ResponseEntity getTeamMatch(@PathVariable Long id){
        return new ResponseEntity<>(teamMatchRepository.findById(id), HttpStatus.OK);
    }

    //POST match
    @PostMapping(value = "/team_matches")
    public ResponseEntity<TeamMatch> postTeamMatch(@RequestBody TeamMatch match){
        teamMatchRepository.save(match);
        return new ResponseEntity<>(match, HttpStatus.CREATED);
    }

    @PutMapping(value="/team_matches/{id}")
    public ResponseEntity<TeamMatch> updateTeamMatch(@RequestBody TeamMatch match) {
        teamMatchRepository.save(match);
        return new ResponseEntity<>(match, HttpStatus.OK);
    }

    @DeleteMapping(value="/team_matches/{id}")
    public ResponseEntity<List<TeamMatch>> deleteTeamMatch(@PathVariable Long id) {
        teamMatchRepository.deleteById(id);
        return new ResponseEntity<>(teamMatchRepository.findAll(), HttpStatus.OK);
    }
}
