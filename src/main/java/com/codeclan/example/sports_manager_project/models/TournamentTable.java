package com.codeclan.example.sports_manager_project.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class TournamentTable {

    private Long id;

    @JsonIgnore
    private List<Team> teams;
    @JsonIgnore
    private List<TeamMatch> matches;

    private ArrayList<TournamentTableRow> rows;

    @JsonIgnore
    private int pointsPerWin;

    @JsonIgnore
    private int pointsPerDraw;

    public TournamentTable(List<Team> teams, List<TeamMatch> matches, int pointsPerWin, int pointsPerDraw) {
        this.matches = matches;
        this.teams = teams;
        this.rows = new ArrayList<>();
        this.pointsPerWin = pointsPerWin;
        this.pointsPerDraw = pointsPerDraw;
        this.calculate();
    }

    public TournamentTable() {}

    public ArrayList<TournamentTableRow> getRows() {
        return this.rows;
    }

    private void calculate() {
        //Create rows
        for (Team team: teams) {
            createRecord(team);
        }
        //Process matches into records
        for(TeamMatch match: matches) {
            if (match.getCompleted()) {
                processMatch(match);
            }
        }
        //Evaluate points for each record
        for(TournamentTableRow row: rows) {
            int points = evaluateRecord(row.getRecord());
            row.setPoints(points);
        }
        //Sort records by number of points
        Collections.sort(rows);
    }

    private void processMatch(TeamMatch match) {
        if (!hasRecord(match.getTeam1())) {
            createRecord(match.getTeam1());
        }
        if (!hasRecord(match.getTeam2())) {
            createRecord(match.getTeam2());
        }
        if(match.isDraw()) {
            this.findRowByTeam(match.getTeam1()).getRecord().addDraw();
            this.findRowByTeam(match.getTeam2()).getRecord().addDraw();
        } else {
            this.findRowByTeam(match.getWinner()).getRecord().addWin();
            this.findRowByTeam(match.getLoser()).getRecord().addLoss();
        }
        this.findRowByTeam(match.getTeam1()).getRecord().addFor(match.getScore1());
        this.findRowByTeam(match.getTeam1()).getRecord().addAgainst(match.getScore2());
        this.findRowByTeam(match.getTeam2()).getRecord().addFor(match.getScore2());
        this.findRowByTeam(match.getTeam2()).getRecord().addAgainst(match.getScore1());
    }

    private int evaluateRecord(TeamRecord record) {
        return record.getWins() * pointsPerWin + record.getDraws() * pointsPerDraw;
    }

    public TournamentTableRow findRowByTeam(Team team) {
        for (TournamentTableRow row: rows) {
            if (row.getTeam() == team) {
                return row;
            }
        }
        return null;
    }

    private Boolean hasRecord (Team team) {
        for (TournamentTableRow row: rows) {
            if (row.getTeam() == team) {
                return true;
            }
        }
        return false;
    }

    private void createRecord(Team team) {
        TournamentTableRow newRow = new TournamentTableRow(team);
        this.rows.add(newRow);
    }

}
