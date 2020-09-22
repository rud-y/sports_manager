package com.codeclan.example.sports_manager_project.components;
import com.codeclan.example.sports_manager_project.models.*;
import com.codeclan.example.sports_manager_project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    TeamRepository teamRepository;
    @Autowired
    TournamentRepository tournamentRepository;
    @Autowired
    VenueRepository venueRepository;
    @Autowired
    TeamMatchRepository teamMatchRepository;
    @Autowired
    ScoreEventRepository scoreEventRepository;
    @Autowired
    CountryRepository countryRepository;
    @Autowired
    SportRepository sportRepository;


    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Country can = new Country("Canada");
        Country eng = new Country("England");
        Country fra = new Country("France");
        Country ger = new Country("Germany");
        Country ita = new Country( "Italy");
        Country sco = new Country("Scotland");
        Country spa = new Country("Spain");
        Country slo = new Country("Slovakia");
        Country usa = new Country("USA");
        Country wal = new Country("Wales");
        Country[] countries = {can, eng, fra, ger, ita, sco, spa, slo, usa, wal};
        for (Country country: countries){
            countryRepository.save(country);
        }

        //premiership

        Date date = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
        Date date2 = new GregorianCalendar(1983, Calendar.DECEMBER, 12).getTime();
        Date date3 = new GregorianCalendar(1989, Calendar.FEBRUARY, 2).getTime();
        Date date4 = new GregorianCalendar(1997, Calendar.JUNE, 6).getTime();



        Person person1 = new Person("Jude", "Bellingham", date, eng );
        Person person2 = new Person("Jurgen", "Klinsmann", date2, ger);
        Person person3 = new Person("Andres", "Iniesta", date3, spa);
        Person person4 = new Person("Aaron", "Ramsdale", date4, eng);
        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);

        Sport sport1 = new Sport("football");
        Sport sport2 = new Sport("basketball");
        Sport sport3 = new Sport("rugby");
        Sport sport4 = new Sport("ice hockey");
        sportRepository.save(sport1);
        sportRepository.save(sport2);
        sportRepository.save(sport3);
        sportRepository.save(sport4);

        Venue venue1 = new Venue("Highbury");
        Venue venue2 = new Venue("Old Trafford");
        Venue venue3 = new Venue("Wembley");
        Venue venue4 = new Venue("Ibrox Stadium");
        venueRepository.save(venue1);
        venueRepository.save(venue2);
        venueRepository.save(venue3);
        venueRepository.save(venue4);

        Team team1 = new Team("Arsenal", "Gunners", venue1);
        Team team2 = new Team("Manchester", "ManU", venue2);
        Team team3 = new Team("Chelsea", "Blues", venue3);
        Team team4 = new Team("Glasgow Rangers", "The Teddy Bears", venue4);
        team1.addPlayer(person1);
        team1.addPlayer(person2);
        team2.addPlayer(person3);
        team2.addPlayer(person4);
        teamRepository.save(team1);
        teamRepository.save(team2);
        teamRepository.save(team3);
        teamRepository.save(team4);

        Tournament tournament1 = new Tournament(sport1, "PremierLeague");
        tournament1.addTeam(team1);
        tournament1.addTeam(team2);
        tournament1.addTeam(team3);
        tournament1.addTeam(team4);
        tournamentRepository.save(tournament1);

//        Date scoreTime1 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
//        Date scoreTime2 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
//        Date scoreTime3 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
//        Date scoreTime4 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();


        TeamMatch teamMatch1 = new TeamMatch(team1, team2, venue1, tournament1);
        teamMatchRepository.save(teamMatch1);
        tournament1.addMatch(teamMatch1);

        ScoreEvent scoreEvent1 = new ScoreEvent(person1, 1, 20, teamMatch1);
        ScoreEvent scoreEvent2 = new ScoreEvent(person4, 1, 31, teamMatch1);
        ScoreEvent scoreEvent3 = new ScoreEvent(person3, 1, 76, teamMatch1);
        ScoreEvent scoreEvent4 = new ScoreEvent(person4, 1, 89, teamMatch1);


        scoreEventRepository.save(scoreEvent1);
        scoreEventRepository.save(scoreEvent2);
        scoreEventRepository.save(scoreEvent3);
        scoreEventRepository.save(scoreEvent4);
        teamMatch1.addScoreEvent(scoreEvent1);
        teamMatch1.addScoreEvent(scoreEvent2);
        teamMatch1.addScoreEvent(scoreEvent3);
        teamMatch1.addScoreEvent(scoreEvent4);
        teamMatchRepository.save(teamMatch1);
        teamMatch1.setCompleted(true);
        teamMatchRepository.save(teamMatch1);


        // nhl
        Date date20 = new GregorianCalendar(1995, Calendar.FEBRUARY, 25).getTime();
        Date date21 = new GregorianCalendar(1997, Calendar.JUNE, 20).getTime();

        Person person20 = new Person("Marian", "Hossa", date20, slo);
        Person person21 = new Person("Auston", "Matthews", date21, can);
        personRepository.save(person20);
        personRepository.save(person21);
        Venue venue20 = new Venue("Wells Fargo Center");
        Venue venue21 = new Venue("Air Canada Centre");
        venueRepository.save(venue20);
        venueRepository.save(venue21);

        Team team20 = new Team("Philadelphia", "PHI", venue20);
        Team team21= new Team("Toronto", "TOR", venue21);
        team20.addPlayer(person20);
        team21.addPlayer(person21);
        teamRepository.save(team20);
        teamRepository.save(team21);

        Tournament tournament2 = new Tournament(sport4, "NHL");
        tournament2.addTeam(team20);
        tournament2.addTeam(team21);
        tournamentRepository.save(tournament2);

    }

}
