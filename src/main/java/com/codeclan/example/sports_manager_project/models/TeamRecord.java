package com.codeclan.example.sports_manager_project.models;

import javax.persistence.*;

@Entity

public class TeamRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column
    private int wins;

    @Column
    private int draws;

    @Column
    private int losses;

    @Column
    private int scoreFor;

    @Column
    private int scoreAgainst;


    public TeamRecord(int wins, int draws, int losses, int scoreFor, int scoreAgainst) {
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
        this.scoreFor = scoreFor;
        this.scoreAgainst = scoreAgainst;
    }

    public TeamRecord() {}

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public void addWin() {
        this.wins += 1;
    }
    public void addLoss() {
        this.losses += 1;
    }
    public void addDraw() {
        this.draws += 1;
    }
    public void addFor(int score) {
        this.scoreFor += score;
    }
    public void addAgainst(int score) {
        this.scoreAgainst += score;
    }



    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int loses) {
        this.losses = loses;
    }

    public int getScoreFor() {
        return scoreFor;
    }

    public void setScoreFor(int scoreFor) {
        this.scoreFor = scoreFor;
    }

    public int getScoreAgainst() {
        return scoreAgainst;
    }

    public void setScoreAgainst(int scoreAgainst) {
        this.scoreAgainst = scoreAgainst;
    }
}
