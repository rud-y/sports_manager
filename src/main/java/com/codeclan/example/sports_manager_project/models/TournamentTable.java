package com.codeclan.example.sports_manager_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;

@Entity
@Table(name = "tables")
public class TournamentTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "tournamentTable")
    @JsonBackReference
    private ArrayList<TeamMatch> matches;

    @OneToMany(mappedBy = "tournamentTable")
    @JsonBackReference
    private HashMap<Team, TeamRecord> records;

    public TournamentTable(ArrayList<TeamMatch> matches, HashMap<Team, TeamRecord> records) {
        this.matches = matches;
        this.records = records;
    }


}
