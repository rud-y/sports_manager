package com.codeclan.example.sports_manager_project.controllers;

import com.codeclan.example.sports_manager_project.models.Person;
import com.codeclan.example.sports_manager_project.models.ScoreEvent;
import com.codeclan.example.sports_manager_project.models.ScoreEvent;
import com.codeclan.example.sports_manager_project.repositories.ScoreEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScoreEventController {

    @Autowired
    ScoreEventRepository scoreEventRepository;

    @GetMapping(value = "/score_events")
    public ResponseEntity<List<ScoreEvent>> getAllScoreEvents(
//            @RequestParam(name = "player", required = false) String player,
            @RequestParam(name = "person", required = false) Long personId) {
//        if(personId != null) {
//            return new ResponseEntity<>(scoreEventRepository.findByPersonId(personId),HttpStatus.OK);
//        }
//        if(player != null){
//            return new ResponseEntity<>(scoreEventRepository.findByPersonLastName(player), HttpStatus.OK);
//        }
        return new ResponseEntity<>(scoreEventRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/score_events/{id}")
    public ResponseEntity getScoreEvent(@PathVariable Long id){
        return new ResponseEntity<>(scoreEventRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/score_events")
    public ResponseEntity<ScoreEvent> postScoreEvent(@RequestBody ScoreEvent scoreEvent){
        scoreEventRepository.save(scoreEvent);
        return new ResponseEntity<>(scoreEvent, HttpStatus.CREATED);
    }

    @PutMapping(value="/score_events/{id}")
    public ResponseEntity<ScoreEvent> updateScoreEvent(@RequestBody ScoreEvent scoreEvent) {
        scoreEventRepository.save(scoreEvent);
        return new ResponseEntity<>(scoreEvent, HttpStatus.OK);
    }

    @DeleteMapping(value="/score_events/{id}")
    public ResponseEntity<List<ScoreEvent>> deleteScoreEvent(@PathVariable Long id) {
        scoreEventRepository.deleteById(id);
        return new ResponseEntity<>(scoreEventRepository.findAll(), HttpStatus.OK);
    }
}
