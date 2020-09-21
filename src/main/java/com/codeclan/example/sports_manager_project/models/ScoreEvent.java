package com.codeclan.example.sports_manager_project.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "score_events")
public class ScoreEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties({"score_events"})
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @Column
    private int value;
    @Column
    private int minute;

    @ManyToOne
    @JsonIgnoreProperties({"score_events"})
    @JoinColumn(name = "team_match_id", nullable = false)
    private TeamMatch teamMatch;


    public ScoreEvent(Person person, int value, int minute, TeamMatch teamMatch) {
        this.person = person;
        this.value = value;
        this.minute = minute;
        this.teamMatch = teamMatch;
    }

    public ScoreEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }
}
