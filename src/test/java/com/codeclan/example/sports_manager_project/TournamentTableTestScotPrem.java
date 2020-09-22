package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TournamentTableTestScotPrem {

    private Tournament scotPrem;
    private Team rangers;
    private Team celtic;
    private Team hibs;
    private Team hearts;
    private TeamMatch match1;
    private TeamMatch match2;
    private TeamMatch match3;
    private TeamMatch match4;
    private TeamMatch match5;
    private TeamMatch match6;

    private TournamentTable table;

    @Before
    public void before() {
        scotPrem = new Tournament(new Sport("Football"), "Scottish Premier");
        rangers = new Team("Glasgow Rangers", "Rangers", new Venue("Ibrox"));
        celtic = new Team("Glasgow Celtic", "Celtic", new Venue("Celtic Park"));
        hibs = new Team("Hibernian", "Hibs", new Venue("Easter Road"));
        hearts = new Team("Heart of Midlothian", "Hearts", new Venue("Tynecastle"));
        match1 = new TeamMatch(rangers, celtic, rangers.getVenue(), scotPrem);
        match2 = new TeamMatch(hibs, hearts, hibs.getVenue(), scotPrem);
        match3 = new TeamMatch(celtic, hibs, celtic.getVenue(), scotPrem);
        match4 = new TeamMatch(hearts, rangers, hearts.getVenue(), scotPrem);
        match5 = new TeamMatch(rangers, hibs, rangers.getVenue(), scotPrem);
        match6 = new TeamMatch(hearts, celtic, hearts.getVenue(), scotPrem);
        match1.setScore1(0);
        match1.setScore2(0);
        match2.setScore1(6);
        match2.setScore2(1);
        match3.setScore1(2);
        match3.setScore2(2);
        match4.setScore1(2);
        match4.setScore2(0);
        match5.setScore1(1);
        match5.setScore2(2);
        match6.setScore1(3);
        match6.setScore2(3);
        table = scotPrem.generateTable();
        //        Hibs 2 1 0 10 4
        //        Hearts 1 1 1 6 9
        //        Celtic 0 3 0 5 5
        //        Rangers 0 1 2 1 4
    }

    @Test
    public void canGetCorrectWins() {
        assertEquals(2, table.getRecords().get(hibs).getWins());
        assertEquals(1, table.getRecords().get(hearts).getWins());
        assertEquals(0, table.getRecords().get(celtic).getWins());
        assertEquals(0, table.getRecords().get(rangers).getWins());
    }

    @Test
    public void canGetCorrectDraws() {
        assertEquals(1, table.getRecords().get(hibs).getDraws());
        assertEquals(1, table.getRecords().get(hearts).getDraws());
        assertEquals(3, table.getRecords().get(celtic).getDraws());
        assertEquals(1, table.getRecords().get(rangers).getDraws());
    }

    @Test
    public void canGetCorrectLosses() {
        assertEquals(0, table.getRecords().get(hibs).getLosses());
        assertEquals(1, table.getRecords().get(hearts).getLosses());
        assertEquals(0, table.getRecords().get(celtic).getLosses());
        assertEquals(2, table.getRecords().get(rangers).getLosses());
    }

    @Test
    public void canGetCorrectFor() {
        assertEquals(10, table.getRecords().get(hibs).getScoreFor());
        assertEquals(6, table.getRecords().get(hearts).getScoreFor());
        assertEquals(5, table.getRecords().get(celtic).getScoreFor());
        assertEquals(1, table.getRecords().get(rangers).getScoreFor());
    }

    @Test
    public void canGetCorrectAgainst() {
        assertEquals(0, table.getRecords().get(hibs).getScoreAgainst());
        assertEquals(1, table.getRecords().get(hearts).getScoreAgainst());
        assertEquals(0, table.getRecords().get(celtic).getScoreAgainst());
        assertEquals(2, table.getRecords().get(rangers).getScoreAgainst());
    }

}
