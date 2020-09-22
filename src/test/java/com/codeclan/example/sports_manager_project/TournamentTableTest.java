package com.codeclan.example.sports_manager_project;


import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class TournamentTableTest {

    private TournamentTable tournamentTable1;
    private TeamMatch teamMatch1;
    private TeamMatch teamMatch2;
    private Team team1;
    private Team team2;
    private Team team3;
    private Team team4;
    private Team team5;
    private Venue venue1;
    private Venue venue2;
    private Venue venue3;
    private Venue venue4;
    private Tournament tournament1;
    private Date date;
    private Person person1;
    private ScoreEvent scoreEvent1;
    private ScoreEvent scoreEvent2;
    private Sport sport1;
    private ArrayList<TeamMatch> matches;

    @Before
    public void before() {
        date = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
        person1 = new Person("Jude", "Bellingham", date, "England");
        sport1 = new Sport("football");
        tournament1 = new Tournament(sport1, "PremierLeague");
        scoreEvent1 = new ScoreEvent(person1, 1, 45, teamMatch1);
        scoreEvent2 = new ScoreEvent(person1, 1, 55, teamMatch1);
        venue1 = new Venue("Wembley");
        venue2 = new Venue("Old Trafford");
        venue3 = new Venue("Upton Park");
        venue4 = new Venue("Stadium");
        team1 = new Team("Arsenal London", "ARS", venue1);
        team2 = new Team("Manchester United", "ManU", venue2);
        team3 = new Team("West Ham", "WHM", venue3);
        team4 = new Team("Milwall", "MIL", venue4);
        team5 = new Team("Norwich", "NOR", new Venue("N stadium"));
        teamMatch1 = new TeamMatch(team1, team2, venue1, tournament1);
        teamMatch2 = new TeamMatch(team3, team4, venue3, tournament1);
        matches = new ArrayList<>();
        matches.add(teamMatch1);
        matches.add(teamMatch2);
        tournamentTable1 = new TournamentTable(matches);
    }

    @Test
    public void canGetRecords() {
        assertEquals(4, tournamentTable1.getRecords().size());
    }

    @Test
    public void canGetRecordKeys() {
        assertTrue(tournamentTable1.getRecords().containsKey(team1));
    }



}


