package com.codeclan.example.sports_manager_project;


import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

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
    public void checkIfHasRecord_false () {
        assertEquals(false , tournamentTable1.hasRecord(team5));
    }

    @Test
    public void checkIfHasRecord_true () {
        assertEquals(true , tournamentTable1.hasRecord(team1));
    }















//    private Tournament scotPrem;
//    private Team rangers;
//    private Team celtic;
//    private Team hibs;
//    private Team hearts;
//    private TeamMatch match1;
//    private TeamMatch match2;
//    private TeamMatch match3;
//    private TeamMatch match4;
//    private TeamMatch match5;
//    private TeamMatch match6;
//
//    private TournamentTable tournamentTable1;
//    private ArrayList<TeamMatch> matches;
//
//    @Before
//    public void before() {
//        scotPrem = new Tournament(new Sport("Football"), "Scottish Premier");
//        rangers = new Team("Glasgow Rangers", "Rangers", new Venue("Ibrox"));
//        celtic = new Team("Glasgow Celtic", "Celtic", new Venue("Celtic Park"));
//        hibs = new Team("Hibernian", "Hibs", new Venue("Easter Road"));
//        hearts = new Team("Heart of Midlothian", "Hearts", new Venue("Tynecastle"));
//        match1 = new TeamMatch(rangers, celtic, rangers.getVenue(), scotPrem);
//        match2 = new TeamMatch(hibs, hearts, hibs.getVenue(), scotPrem);
//        match3 = new TeamMatch(celtic, hibs, celtic.getVenue(), scotPrem);
//        match4 = new TeamMatch(hearts, rangers, hearts.getVenue(), scotPrem);
//        match5 = new TeamMatch(rangers, hibs, rangers.getVenue(), scotPrem);
//        match6 = new TeamMatch(hearts, celtic, hearts.getVenue(), scotPrem);
//        match1.setScore1(0);
//        match1.setScore2(0);
//        match2.setScore1(6);
//        match2.setScore2(1);
//        match3.setScore1(2);
//        match3.setScore2(2);
//        match4.setScore1(2);
//        match4.setScore2(0);
//        match5.setScore1(1);
//        match5.setScore2(2);
//        match6.setScore1(3);
//        match6.setScore2(3);
//
//        matches.add(match1);
//        matches.add(match2);
//        matches.add(match3);
//        matches.add(match4);
//        matches.add(match5);
//        matches.add(match6);
//        tournamentTable1 = new TournamentTable(matches);
//    }
//
//        @Test
//        public void canCheckTeamIsInTable () {
//            assertEquals(true, tournamentTable1.isNotInTable(hibs));
//        }



    }
