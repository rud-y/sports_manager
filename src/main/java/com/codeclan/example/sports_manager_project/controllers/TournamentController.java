package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Tournament;
import com.codeclan.example.sports_manager_project.models.Tournament;
import com.codeclan.example.sports_manager_project.models.Venue;
import com.codeclan.example.sports_manager_project.repositories.TournamentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TournamentController {

    @Autowired
    TournamentRepository tournamentRepository;

    @GetMapping(value = "/tournaments")
    public ResponseEntity<List<Tournament>> getAllTournaments (
            @RequestParam(name = "team", required = false) String team) {
//        if(team != null) {
//            return new ResponseEntity<>(tournamentRepository.findByTeamsName(team), HttpStatus.OK);
//        }
        return new ResponseEntity<>(tournamentRepository.findAll(), HttpStatus.OK);
    }


    @GetMapping(value = "/tournaments/{id}")
    public ResponseEntity getTournament(@PathVariable Long id) {
        return new ResponseEntity<>(tournamentRepository.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/tournaments/{id}/table")
    public ResponseEntity getTournamentTable(@PathVariable Long id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        if (tournament.isPresent() ) {
            return new ResponseEntity<>(tournament.get().generateTable(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping(value = "/tournaments/{id}/teams")
    public ResponseEntity getTeams(@PathVariable Long id) {
        Optional<Tournament> tournament = tournamentRepository.findById(id);
        if (tournament.isPresent() ) {
            return new ResponseEntity<>(tournament.get().getTeams(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
    }


    @PostMapping(value = "/tournaments")
    public ResponseEntity<Tournament> postTournament(@RequestBody Tournament tournament) {
        tournamentRepository.save(tournament);
        return new ResponseEntity<>(tournament, HttpStatus.CREATED);
    }

    @PutMapping(value = "/tournaments/{id}")
    public ResponseEntity<Tournament> updateTournament(@RequestBody Tournament tournament) {
        tournamentRepository.save(tournament);
        return new ResponseEntity<>(tournament, HttpStatus.OK);
    }

    @DeleteMapping(value = "/tournaments/{id}")
    public ResponseEntity<List<Tournament>> deleteTournament(@PathVariable Long id) {
        tournamentRepository.deleteById(id);
        return new ResponseEntity<>(tournamentRepository.findAll(), HttpStatus.OK);
    }

}
