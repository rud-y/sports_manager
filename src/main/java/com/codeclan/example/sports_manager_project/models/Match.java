package com.codeclan.example.sports_manager_project.models;
import com.codeclan.example.sports_manager_project.behaviours.IPlay;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private IPlay participant1;

    @Column
    private IPlay participant2;

    @Column
    private int score1;

    @Column
    private int score2;

    @Column
    private Venue venue;

    @OneToMany(mappedBy = "match")
    @JsonIgnoreProperties({"match"})
    private List<ScoreEvent> scoreEvents;







}
