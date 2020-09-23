package com.codeclan.example.sports_manager_project;

import com.codeclan.example.sports_manager_project.models.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DataLoaderComparison {

    Tournament alphabetLeague;
    Team alpha;
    Team beta;
    TeamMatch match1;
    TeamMatch match2;

    @Before
    public void before() {
        //sports
        Sport football = new Sport("Football");

        //venues
        Venue pisces = new Venue("Pisces Park");
        Venue scorpio = new Venue("Scorpio Stadium");

        //teams
        alpha = new Team("Alpha United", "Alpha U", pisces);
        beta = new Team("Beta City", "Beta C", scorpio);

        //tournament
        alphabetLeague = new Tournament("Alphabet League", football, 3, 1);

        //matches
        match1 = new TeamMatch(alpha, beta, alpha.getVenue(), alphabetLeague);
        match2 = new TeamMatch(beta, alpha, beta.getVenue(), alphabetLeague);
    }

    @Test
    public void canAddTeams() {
        alphabetLeague.addTeam(alpha);
        alphabetLeague.addTeam(beta);
        assertEquals(2, alphabetLeague.getTeams().size());
    }

    @Test
    public void canAddMatches() {
        alphabetLeague.addMatch(match1);
        alphabetLeague.addMatch(match2);
        assertEquals(2, alphabetLeague.getMatches().size());
    }

    @Test
    public void matchHasTournament() {
        alphabetLeague.addMatch(match1);
        assertEquals(alphabetLeague, match1.getTournament());
    }

}
