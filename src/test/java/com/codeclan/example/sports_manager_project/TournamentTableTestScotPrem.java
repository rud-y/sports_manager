package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
        scotPrem = new Tournament("Scottish Premier", new Sport("Football"));
        rangers = new Team("Glasgow Rangers", "Rangers", new Venue("Ibrox"));
        celtic = new Team("Glasgow Celtic", "Celtic", new Venue("Celtic Park"));
        hibs = new Team("Hibernian", "Hibs", new Venue("Easter Road"));
        hearts = new Team("Heart of Midlothian", "Hearts", new Venue("Tynecastle"));
        match1 = new TeamMatch(rangers, celtic, rangers.getVenue());
        match2 = new TeamMatch(hibs, hearts, hibs.getVenue());
        match3 = new TeamMatch(celtic, hibs, celtic.getVenue());
        match4 = new TeamMatch(hearts, rangers, hearts.getVenue());
        match5 = new TeamMatch(rangers, hibs, rangers.getVenue());
        match6 = new TeamMatch(hearts, celtic, hearts.getVenue());
        TeamMatch[] matches = {match1, match2, match3, match4, match5, match6};
        for(TeamMatch match: matches) {
            scotPrem.addMatch(match);
        }
        // Rangers 0, Celtic 0
        match1.setScore1(0);
        match1.setScore2(0);
        // Hibs 6 Hearts 1
        match2.setScore1(6);
        match2.setScore2(1);
        // Celtic 2 Hibs 2
        match3.setScore1(2);
        match3.setScore2(2);
        // Hearts 2 Rangers 0
        match4.setScore1(2);
        match4.setScore2(0);
        // Rangers 1 Hibs 2
        match5.setScore1(1);
        match5.setScore2(2);
        // Hearts 3 Celtic 3
        match6.setScore1(3);
        match6.setScore2(3);
        scotPrem.addMatch(match1);
        scotPrem.addMatch(match2);
        scotPrem.addMatch(match3);
        scotPrem.addMatch(match4);
        scotPrem.addMatch(match5);
        scotPrem.addMatch(match6);
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
    public void canGetCorrectDrawsHibs() {
        assertEquals(1, table.getRecords().get(hibs).getDraws());
    }

    @Test
    public void canGetCorrectDrawsHearts() {
        assertEquals(1, table.getRecords().get(hearts).getDraws());
    }
    @Test
    public void canGetCorrectDrawsCeltic() {
        assertEquals(3, table.getRecords().get(celtic).getDraws());
    }
    @Test
    public void canGetCorrectDrawsRangers() {
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
        assertEquals(4, table.getRecords().get(hibs).getScoreAgainst());
        assertEquals(9, table.getRecords().get(hearts).getScoreAgainst());
        assertEquals(5, table.getRecords().get(celtic).getScoreAgainst());
        assertEquals(4, table.getRecords().get(rangers).getScoreAgainst());
    }

}
