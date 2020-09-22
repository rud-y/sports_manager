package com.codeclan.example.sports_manager_project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TournamentTable {

    private Long id;

    private List<TeamMatch> matches;

    private HashMap<Team, TeamRecord> records;

    public TournamentTable(List<TeamMatch> matches) {
        this.matches = matches;
        this.records = new HashMap<>();
    }

    public TournamentTable() {}

    public HashMap<Team, TeamRecord> getRecords() {
        return this.records;
    }

    public void calculate() {
        for(TeamMatch match: matches) {
            processMatch(match);
        }
    }

    private void processMatch(TeamMatch match) {
        if (!hasRecord(match.getTeam1())) {
            createRecord(match.getTeam1());
        }
        if (!hasRecord(match.getTeam2())) {
            createRecord(match.getTeam2());
        }
        if(match.isDraw()) {
            this.records.get(match.getTeam1()).addDraw();
            this.records.get(match.getTeam2()).addDraw();
        } else {
            this.records.get(match.getWinner()).addWin();
            this.records.get(match.getLoser()).addLoss();
        }
        this.records.get(match.getTeam1()).addFor(match.getScore1());
        this.records.get(match.getTeam1()).addAgainst(match.getScore2());
        this.records.get(match.getTeam2()).addFor(match.getScore2());
        this.records.get(match.getTeam2()).addAgainst(match.getScore1());
    }

    private Boolean hasRecord (Team team) {
        return records.containsKey(team);
    }

    private void createRecord(Team team) {
        records.put(team, new TeamRecord());
    }


}
