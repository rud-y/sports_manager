package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        TeamMatch[] matches = {match1, match2, match3, match4, match5, match6};
        ArrayList<TeamMatch> matchesArrayList = new ArrayList<>();
        for(TeamMatch match: matches) {
            matchesArrayList.add(match);
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

        table = new TournamentTable(matchesArrayList, 3, 1);
        //        Hibs 2 1 0 10 4 7
        //        Hearts 1 1 1 6 9 4
        //        Celtic 0 3 0 5 5 3
        //        Rangers 0 1 2 1 4 1
    }

    @Test
    public void hasRows() {
        assertEquals(4, table.getRows().size());
    }

    @Test
    public void canGetCorrectWins() {
        assertEquals(2, table.findRowByTeam(hibs).getRecord().getWins());
        assertEquals(1, table.findRowByTeam(hearts).getRecord().getWins());
        assertEquals(0, table.findRowByTeam(celtic).getRecord().getWins());
        assertEquals(0, table.findRowByTeam(rangers).getRecord().getWins());
    }

    @Test
    public void canGetCorrectDraws() {
        assertEquals(1, table.findRowByTeam(hibs).getRecord().getDraws());
        assertEquals(1, table.findRowByTeam(hearts).getRecord().getDraws());
        assertEquals(3, table.findRowByTeam(celtic).getRecord().getDraws());
        assertEquals(1, table.findRowByTeam(rangers).getRecord().getDraws());
    }

    @Test
    public void canGetCorrectDrawsHibs() {
        assertEquals(1, table.findRowByTeam(hibs).getRecord().getDraws());
    }

    @Test
    public void canGetCorrectDrawsHearts() {
        assertEquals(1, table.findRowByTeam(hearts).getRecord().getDraws());
    }
    @Test
    public void canGetCorrectDrawsCeltic() {
        assertEquals(3, table.findRowByTeam(celtic).getRecord().getDraws());
    }
    @Test
    public void canGetCorrectDrawsRangers() {
        assertEquals(1, table.findRowByTeam(rangers).getRecord().getDraws());
    }

    @Test
    public void canGetCorrectLosses() {
        assertEquals(0, table.findRowByTeam(hibs).getRecord().getLosses());
        assertEquals(1, table.findRowByTeam(hearts).getRecord().getLosses());
        assertEquals(0, table.findRowByTeam(celtic).getRecord().getLosses());
        assertEquals(2, table.findRowByTeam(rangers).getRecord().getLosses());
    }

    @Test
    public void canGetCorrectFor() {
        assertEquals(10, table.findRowByTeam(hibs).getRecord().getScoreFor());
        assertEquals(6, table.findRowByTeam(hearts).getRecord().getScoreFor());
        assertEquals(5, table.findRowByTeam(celtic).getRecord().getScoreFor());
        assertEquals(1, table.findRowByTeam(rangers).getRecord().getScoreFor());
    }

    @Test
    public void canGetCorrectAgainst() {
        assertEquals(4, table.findRowByTeam(hibs).getRecord().getScoreAgainst());
        assertEquals(9, table.findRowByTeam(hearts).getRecord().getScoreAgainst());
        assertEquals(5, table.findRowByTeam(celtic).getRecord().getScoreAgainst());
        assertEquals(4, table.findRowByTeam(rangers).getRecord().getScoreAgainst());
    }

    @Test
    public void canGetPoints() {
        assertEquals(7, table.findRowByTeam(hibs).getPoints());
        assertEquals(4, table.findRowByTeam(hearts).getPoints());
        assertEquals(3, table.findRowByTeam(celtic).getPoints());
        assertEquals(1, table.findRowByTeam(rangers).getPoints());
    }

    @Test
    public void canSortTableCorrectly() {
        assertEquals(0, table.getRows().indexOf(table.findRowByTeam(hibs)));
        assertEquals(1, table.getRows().indexOf(table.findRowByTeam(hearts)));
        assertEquals(2, table.getRows().indexOf(table.findRowByTeam(celtic)));
        assertEquals(3, table.getRows().indexOf(table.findRowByTeam(rangers)));
    }
}
