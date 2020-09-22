package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class TournamentTest {

    private Tournament tournament;
    private Team team;
    private Team team2;
    private Date date;
    private Sport sport1;
    private Person person1;
    private Venue venue;

    @Before
    public void before() {
        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 20).getTime();
        sport1 = new Sport("football");
        person1  = new Person("David", "Beckham", date, "England" );
        venue = new Venue("Emirates Stadium");
        team = new Team("Arsenal London", "ARS", venue);
        team2 = new Team("Manchester United", "MAN", venue);
        tournament = new Tournament(sport1, "Premier League");
    }

    @Test
    public void canAddTeamsToTournament() {
        tournament.addTeam(team);
        tournament.addTeam(team2);
        assertEquals(2, tournament.getTeams().size());
    }


}
