package com.codeclan.example.sports_manager_project;
import com.codeclan.example.sports_manager_project.models.Country;
import com.codeclan.example.sports_manager_project.models.Person;
import com.codeclan.example.sports_manager_project.models.Team;
import com.codeclan.example.sports_manager_project.models.Venue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TeamTest {

    Team team;
    Date date;
    Person person1;
    Venue venue;

    @Before
    public void before() {
        date = new GregorianCalendar(2020, Calendar.SEPTEMBER, 20).getTime();
        person1  = new Person("David", "Beckham", date, Country.ENGLAND );
        venue = new Venue("Emirates Stadium");
        team = new Team("Arsenal London", "ARS", venue);
    }

    @Test
    public void canAddPersonToTeam() {
        team.addPlayer(person1);
        assertEquals(1 ,team.getPlayers().size());
    }
}
