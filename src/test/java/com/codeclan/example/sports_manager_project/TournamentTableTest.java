package com.codeclan.example.sports_manager_project;
import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TournamentTableTest {

    private Tournament tournament;
    private TournamentTable table;
    private TeamMatch match1;
    private TeamMatch match2;
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team team5;
    private ArrayList<Team> teams;
    private Venue venue1;
    private Venue venue2;
    private Venue venue3;
    private Venue venue4;
    private ArrayList<TeamMatch> matches;

    @Before()
    public void before() {

        tournament = new Tournament("A League", new Sport("Football"), 3, 1);

        venue1 = new Venue("Wembley");
        venue2 = new Venue("Old Trafford");
        venue3 = new Venue("Upton Park");
        venue4 = new Venue("Carrow Road");

        team1 = new Team("Arsenal", "ARS", venue1);
        team2 = new Team("Manchester United", "ManU", venue2);
        team3 = new Team("West Ham", "WHM", venue3);
        team4  = new Team("Norwich", "NOR", venue4);
        teams = new ArrayList<>();
        teams.add(team1);
        teams.add(team2);
        teams.add(team3);
        teams.add(team4);

        match1 = new TeamMatch(team1, team2, team1.getVenue(), tournament);
        match1.setScore1(2);
        match1.setScore2(1);
        match2 = new TeamMatch(team3, team4, team3.getVenue(), tournament);
        match2.setScore1(2);
        match2.setScore2(3);
        matches = new ArrayList<>();
        matches.add(match1);
        matches.add(match2);

        table = new TournamentTable(teams, matches, 3,1);

    }

    @Test
    public void canGetRecords() {
        assertEquals(4, table.getRows().size());
    }

    @Test
    public void canGetWins() {
        assertEquals(1, table.findRowByTeam(team1).getRecord().getWins());
    }

    @Test
    public void canGetDraw() {
        assertEquals(0, table.findRowByTeam(team1).getRecord().getDraws());
    }

    @Test
    public void canGetLoss() {
        assertEquals(1, table.findRowByTeam(team2).getRecord().getLosses());
    }

    @Test
    public void canGetScoresFor() {
        assertEquals(2, table.findRowByTeam(team1).getRecord().getScoreFor());
    }

    @Test
    public void canGetScoresAgainst(){
        assertEquals(2, table.findRowByTeam(team2).getRecord().getScoreAgainst());
    }

    @Test
    public void canGetCorrectSorting() {
        assertEquals(0, table.getRows().indexOf(table.findRowByTeam(team4)));
    }

}
