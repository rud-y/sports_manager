package com.codeclan.example.sports_manager_project.models;

public class TournamentTableRow implements Comparable<TournamentTableRow>{

    private Team team;
    private TeamRecord record;
    private int points;

    public TournamentTableRow(Team team) {
        this.team = team;
        this.record = new TeamRecord();
        this.points = 0;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public TeamRecord getRecord() {
        return record;
    }

    public void setRecord(TeamRecord record) {
        this.record = record;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public int compareTo(TournamentTableRow other) {
        return other.points - this.points;
    }
}
