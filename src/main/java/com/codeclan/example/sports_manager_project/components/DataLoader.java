package com.codeclan.example.sports_manager_project.components;
import com.codeclan.example.sports_manager_project.models.*;
import com.codeclan.example.sports_manager_project.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

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
        //premiership
        Date date1 = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
        Date date2 = new GregorianCalendar(1983, Calendar.DECEMBER, 12).getTime();
        Date date3 = new GregorianCalendar(1989, Calendar.FEBRUARY, 2).getTime();
        Date date4 = new GregorianCalendar(1997, Calendar.JUNE, 6).getTime();

        Person person1 = new Person("Jude", "Bellingham", date1, new Country("England"));
        Person person2 = new Person("Jurgen", "Klinsmann", date2, new Country("Germany"));
        Person person3 = new Person("Andres", "Iniesta", date3, new Country("Spain"));
        Person person4 = new Person("Aaron", "Ramsdale", date4, new Country("England"));
        Person person5 = new Person("Mesut", "Oxil", date1, new Country("Germany"));
        Person person6 = new Person("David", "Silva", date2, new Country("Spain"));
        Person person7 = new Person("Vincent", "Kompany", date3, new Country("Belgium"));
        Person person8 = new Person("Gerard", "Pique", date4, new Country("Spain"));
        Person person9 = new Person("Edinson", "Cavani", date1, new Country("Uruguay"));
        Person person10 = new Person("Louis", "Suarez", date2, new Country("Uruguay"));

        personRepository.save(person1);
        personRepository.save(person2);
        personRepository.save(person3);
        personRepository.save(person4);
        personRepository.save(person5);
        personRepository.save(person6);
        personRepository.save(person7);
        personRepository.save(person8);
        personRepository.save(person9);
        personRepository.save(person10);


        Team arsenal = new Team("Arsenal", "ARS", new Venue("Highbury"));
        Team manchester = new Team("Manchester", "MAN", new Venue("Old Trafford"));
        Team chelsea = new Team("Chelsea", "CHE", new Venue("Wembley"));
        Team rangers = new Team("Glasgow Rangers", "GLA",  new Venue("Ibrox Stadium"));
        Team spurs = new Team("Tottenham Hotspur", "TOT",  new Venue("White Hart Lane"));
        Team hibs = new Team("Hibernians", "HIB",  new Venue("White Hart Lane"));

        arsenal.addPlayer(person1);
        arsenal.addPlayer(person2);
        manchester.addPlayer(person3);
        manchester.addPlayer(person4);
        chelsea.addPlayer(person5);
        chelsea.addPlayer(person6);
        rangers.addPlayer(person7);
        rangers.addPlayer(person8);
        spurs.addPlayer(person9);
        hibs.addPlayer(person10);
        teamRepository.save(arsenal);
        teamRepository.save(manchester);
        teamRepository.save(chelsea);
        teamRepository.save(rangers);
        teamRepository.save(spurs);
        teamRepository.save(hibs);
        //Tournament / Matches
        Tournament premierLeague = new Tournament(new Sport("football"), "Premier League");
        premierLeague.addTeam(arsenal);
        premierLeague.addTeam(manchester);
        premierLeague.addTeam(chelsea);
        premierLeague.addTeam(rangers);
        premierLeague.addTeam(spurs);
        tournamentRepository.save(premierLeague);


        TeamMatch teamMatch1 = new TeamMatch(arsenal, manchester, arsenal.getVenue());
        TeamMatch teamMatch2 = new TeamMatch(chelsea, rangers, chelsea.getVenue());
        TeamMatch teamMatch3 = new TeamMatch(spurs, hibs, spurs.getVenue());
        teamMatchRepository.save(teamMatch1);
        teamMatchRepository.save(teamMatch2);
        teamMatchRepository.save(teamMatch3);

//        premierLeague.addMatch(teamMatch1);

        //PLAYER NUMBERS:  1,2:arsenal, 3,4:manchester, 5,6:chelsea, 7,8:rangers, 9:spurs, 10:hibs
        ScoreEvent scoreEvent1 = new ScoreEvent(person1, 1, 20, teamMatch1);
        ScoreEvent scoreEvent2 = new ScoreEvent(person5, 1, 60, teamMatch2);
        ScoreEvent scoreEvent3 = new ScoreEvent(person10, 1, 40, teamMatch3);
        scoreEventRepository.save(scoreEvent1);
        scoreEventRepository.save(scoreEvent2);
        scoreEventRepository.save(scoreEvent3);
        teamMatch1.addScoreEvent(scoreEvent1);
        teamMatch2.addScoreEvent(scoreEvent2);
        teamMatch3.addScoreEvent(scoreEvent3);
        teamMatchRepository.save(teamMatch1);
        teamMatchRepository.save(teamMatch2);
        teamMatchRepository.save(teamMatch3);
        //SCORES: arsenal-manchester 1-0,  chelsea-rangers 1-0, spurs-hibs 0-1





//        Sport sport1 = new Sport("football");
//        Sport sport2 = new Sport("basketball");
//        Sport sport3 = new Sport("rugby");
//        Sport sport4 = new Sport("ice hockey");
//        sportRepository.save(sport1);
//        sportRepository.save(sport2);
//        sportRepository.save(sport3);
//        sportRepository.save(sport4);

//        Venue venue1 = new Venue("Highbury");
//        Venue venue2 = new Venue("Old Trafford");
//        Venue venue3 = new Venue("Wembley");
//        Venue venue4 = new Venue("Ibrox Stadium");
//        venueRepository.save(venue1);
//        venueRepository.save(venue2);
//        venueRepository.save(venue3);
//        venueRepository.save(venue4);

//        Country country1 = new Country("England");
//        Country country2 = new Country("France");
//        Country country3 = new Country("Spain");
//        Country country4 = new Country("Italy");
//        countryRepository.save(country1);
//        countryRepository.save(country2);
//        countryRepository.save(country3);
//        countryRepository.save(country4);

    }

}
