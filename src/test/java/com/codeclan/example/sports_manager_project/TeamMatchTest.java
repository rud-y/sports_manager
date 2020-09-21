package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TeamMatchTest {

    private TeamMatch teamMatch1;
    private Team team1;
    private Team team2;
    private Venue venue1;
    private Venue venue2;
    private Tournament tournament1;
    private Date date;
    private Sport sport1;

    @Before
    public void before() {
        date = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
        tournament1 = new Tournament(sport1, "PremierLeague");
        teamMatch1 = new TeamMatch(team1, team2, venue1, tournament1);
        venue1 = new Venue("Wembley");
        venue2 = new Venue("Old Trafford");
        team1 = new Team("Arsenal London", "ARS", venue1);
        team2 = new Team("Manchester United", "ManU", venue2);
    }


    @Test
    public void matchIsFinished_withDraw() {
        teamMatch1.setScore1(2);
        teamMatch1.setScore2(2);
        teamMatch1.setCompleted(true);
        assertEquals(true, teamMatch1.isDraw());
    }


//    @Test
//    public void oneOfTheTeamsCanWin() {
//        teamMatch1.setScore1(1);
//        teamMatch1.setScore2(0);
//        teamMatch1.setCompleted(true);
//        Team winningTeam = teamMatch1.getWinner();
//        assertEquals(1,teamMatch1.getScore1() );
//    }

}
