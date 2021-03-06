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

        //countries
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

        //sports
        Sport basketball = new Sport("Basketball");
        Sport football = new Sport("Football");
        Sport iceHockey = new Sport("Ice Hockey");
        Sport rugbyLeague = new Sport("Rugby League");
        Sport rugbyUnion = new Sport("Rugby Union");
        Sport[] sports = {basketball, football, iceHockey, rugbyLeague, rugbyUnion};
        for (Sport sport: sports) {
            sportRepository.save(sport);
        }
        sportRepository.save(football);

        //ALPHABET LEAGUE
        //venues
        Venue aquarius = new Venue("Aquarius Arena");
        Venue aries = new Venue("Aries Arena");
        Venue cancer = new Venue("Zodiac Zone ");
        Venue capricorn = new Venue("Capricorn Crescent");
        Venue gemini = new Venue("Gemini Ground");
        Venue leo = new Venue("Leo Lane");
        Venue libra = new Venue("Libra Links");
        Venue pisces = new Venue("Pisces Park");
        Venue sagittarius = new Venue("Sagittarius Street");
        Venue scorpio = new Venue("Scorpio Stadium");
        Venue taurus = new Venue("Taurus Towers");
        Venue virgo = new Venue("Virgo View");
        Venue[] venues = {aquarius, aries, cancer, capricorn, gemini, leo, libra, pisces, sagittarius, scorpio, taurus, virgo};
        for (Venue venue: venues) {
            venueRepository.save(venue);
        }

        //teams
        Team alpha = new Team("Alphatown Alpacas", "Alpacas", aquarius);
        Team beta = new Team("Betaville Beetles", "Beetles", aries);
        Team gamma = new Team("Gammafield Gnus", "Gnus", cancer);
        Team delta = new Team("Deltabridge Dolphins", "Dolphins", capricorn);
        Team epsilon = new Team("Epsilon Elks", "Elks", gemini);
        Team zeta = new Team("Zetavale Zebras", "Zebras", leo);
        Team eta = new Team("Etaville Elephants", "Elephants", libra);
        Team theta = new Team("Thetaby Terrapins", "Terrapins", pisces);
        Team iota = new Team("Iota City Ibexes", "Ibexes", sagittarius);
        Team kappa = new Team("Kappaford Koalas", "Koalas", scorpio);
        Team lambda = new Team("Lambdabridge Llamas", "Llamas", taurus);
        Team mu = new Team("Mucastle Molluscs", "Molluscs", virgo);
        Team[] teams = {alpha, beta, gamma, delta, epsilon, zeta, eta, theta, iota, kappa, lambda, mu};
        for (Team team: teams) {
            teamRepository.save(team);
        }

        //tournament
        Tournament alphabetLeague = new Tournament("Alphabet League", rugbyLeague, 2, 1);
        tournamentRepository.save(alphabetLeague);

        //add teams to tournament
        for (Team team: teams) {
            alphabetLeague.addTeam(team);
        }
        tournamentRepository.save(alphabetLeague);

        //matches
        TeamMatch match1 = new TeamMatch(alpha, beta, alpha.getVenue(), alphabetLeague);
        match1.setScore1(24);
        match1.setScore2(20);
        match1.setCompleted(true);
        teamMatchRepository.save(match1);
        TeamMatch match2 = new TeamMatch(gamma, delta, gamma.getVenue(), alphabetLeague);
        match2.setScore1(16);
        match2.setScore2(20);
        match2.setCompleted(true);
        teamMatchRepository.save(match2);
        TeamMatch match3 = new TeamMatch(eta, epsilon, beta.getVenue(), alphabetLeague);
        match3.setScore1(28);
        match3.setScore2(12);
        match3.setCompleted(true);
        teamMatchRepository.save(match3);
        TeamMatch match4 = new TeamMatch(kappa, lambda, delta.getVenue(), alphabetLeague);
        match4.setScore1(30);
        match4.setScore2(6);
        match4.setCompleted(true);
        teamMatchRepository.save(match4);


        //CODECLAN CHAMPIONSHIP
        //Venues
        Venue amstrad = new Venue("Amstrad Arena");
        Venue atari = new Venue("Atari Avenue");
        Venue commodore = new Venue("Commodore Crescent");
        Venue dell = new Venue("Dell Lane");
        Venue hewlett = new Venue("Hewlett Hall");
        Venue packard = new Venue("Packard Park");
        Venue sinclair = new Venue("Sinclair Street");
        Venue toshiba = new Venue("Toshiba Terrace");
        Venue[] codeclanVenues = {amstrad, atari, commodore, dell, hewlett, packard, sinclair, toshiba};
        for (Venue venue: codeclanVenues) {
            venueRepository.save(venue);
        }

        //Teams
        Team cobol = new Team("Cobol Albion", "Cobol A", amstrad);
        Team cplusplus = new Team("C++ Wednesday", "C++ Weds", atari);
        Team fortran = new Team("Fortran Rangers", "Fortran R", commodore);
        Team haskell = new Team("Haskell Town", "Haskell T", dell);
        Team java = new Team("Java City", "Java C", hewlett);
        Team pascal = new Team("Pascal Athletic", "Pascal A", packard);
        Team python = new Team("Python United", "Python Utd", sinclair);
        Team ruby = new Team("Ruby Rovers", "Ruby R", toshiba);
        Team[] codeclanTeams = {cobol, cplusplus, fortran, haskell, java, pascal, python, ruby};
        for (Team team: codeclanTeams) {
            teamRepository.save(team);
        }

        //tournament
        Tournament codeclanLeague = new Tournament("Codeclan Championship", football, 3, 1);
        tournamentRepository.save(codeclanLeague);

        //add teams to tournament
        for (Team team: codeclanTeams) {
            codeclanLeague.addTeam(team);
        }
        tournamentRepository.save(codeclanLeague);

        //matches
        TeamMatch game1 = new TeamMatch(cobol, haskell, cobol.getVenue(), codeclanLeague);
        teamMatchRepository.save(game1);
        TeamMatch game2 = new TeamMatch(fortran, cplusplus, fortran.getVenue(), codeclanLeague);
        teamMatchRepository.save(game2);
        TeamMatch game3 = new TeamMatch(java, pascal, cobol.getVenue(), codeclanLeague);
        teamMatchRepository.save(game3);



        //NHL
        //PLAYOFFS
        Venue bell = new Venue("Bell Center");
        Venue air = new Venue("Air Canada Center");
        Venue td = new Venue("TD Center");
        Venue chi = new Venue("Sears Arena");
        Venue steel = new Venue("Wings Arena");
        Venue oil = new Venue("Gretzky Arena");
        Venue[] nhlVenues = {bell, air, td, chi, steel, oil};
        for (Venue venue: nhlVenues) {
            venueRepository.save(venue);
        }

        Team montreal = new Team("Montral Canadiens", "Habs", bell);
        Team toronto = new Team("Toronto Maple Leafs", "Leafs", air);
        Team boston = new Team("Boston Bruins", "Bruins", td);
        Team chicago = new Team("Chicago Blackhawks", "Koalas", chi);
        Team detroit  = new Team("Detroit Red Wings", "Wings", steel);
        Team edmonton = new Team("Edmonton Oilers", "Oilers", oil);
        Team[] nhlTeams = {montreal, toronto, boston, chicago, detroit, edmonton};
        for (Team team: nhlTeams) {
            teamRepository.save(team);
        }

        Tournament nhl = new Tournament("NHL", iceHockey, 2, 1);
        tournamentRepository.save(nhl);
        for(Team team: nhlTeams){
            nhl.addTeam(team);
        }
        tournamentRepository.save(nhl);

        //matches - results
        TeamMatch nhlMatch1 = new TeamMatch(boston, chicago, td, nhl);
        nhlMatch1.setScore1(4);
        nhlMatch1.setScore2(6);
        nhlMatch1.setCompleted(true);
//        teamMatchRepository.save(nhlMatch1);
        TeamMatch nhlMatch2 = new TeamMatch(edmonton, detroit, oil, nhl);
        nhlMatch2.setScore1(3);
        nhlMatch2.setScore2(1);
        nhlMatch2.setCompleted(true);
//        teamMatchRepository.save(nhlMatch2);
        TeamMatch nhlMatch3 = new TeamMatch(toronto, montreal , air, nhl);
        nhlMatch3.setScore1(5);
        nhlMatch3.setScore2(4);
        nhlMatch3.setCompleted(true);
//        teamMatchRepository.save(nhlMatch3);

        TeamMatch nhlMatch4 = new TeamMatch(chicago, montreal , air, nhl);
        nhlMatch4.setScore1(2);
        nhlMatch4.setScore2(4);
        nhlMatch4.setCompleted(true);
//        teamMatchRepository.save(nhlMatch4);

        TeamMatch nhlMatch5 = new TeamMatch(edmonton, toronto , air, nhl);
        nhlMatch5.setScore1(1);
        nhlMatch5.setScore2(6);
        nhlMatch5.setCompleted(true);
//        teamMatchRepository.save(nhlMatch5);

        TeamMatch nhlMatch6 = new TeamMatch(boston, detroit , air, nhl);
        nhlMatch6.setScore1(7);
        nhlMatch6.setScore2(3);
        nhlMatch6.setCompleted(true);
//        teamMatchRepository.save(nhlMatch6);

        //matches - fixtures
        TeamMatch nhlMatch7 = new TeamMatch(detroit, toronto, steel, nhl);
        nhlMatch7.setCompleted(false);

        TeamMatch nhlMatch8 = new TeamMatch(boston, edmonton, steel, nhl);
        nhlMatch8.setCompleted(false);

        TeamMatch nhlMatch9 = new TeamMatch(chicago, boston, steel, nhl);
        nhlMatch9.setCompleted(false);

        TeamMatch nhlMatch10 = new TeamMatch(toronto, chicago, steel, nhl);
        nhlMatch10.setCompleted(false);

        TeamMatch[] nhlMatches = {nhlMatch1, nhlMatch2, nhlMatch3, nhlMatch4, nhlMatch5, nhlMatch6, nhlMatch7, nhlMatch8, nhlMatch9, nhlMatch10};
        for(TeamMatch match: nhlMatches) {
            teamMatchRepository.save(match);
        }



        //        //premiership
//
//        Date date = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
//        Date date1 = new GregorianCalendar(1991, Calendar.AUGUST, 8).getTime();
//        Date date2 = new GregorianCalendar(1983, Calendar.DECEMBER, 12).getTime();
//        Date date3 = new GregorianCalendar(1989, Calendar.FEBRUARY, 2).getTime();
//        Date date4 = new GregorianCalendar(1997, Calendar.JUNE, 6).getTime();
//
//        Person person1 = new Person("Jude", "Bellingham", date, eng );
//        Person person2 = new Person("Jurgen", "Klinsmann", date2, ger);
//        Person person3 = new Person("Andres", "Iniesta", date3, spa);
//        Person person4 = new Person("Aaron", "Ramsdale", date4, eng);
//        personRepository.save(person1);
//        personRepository.save(person2);
//        personRepository.save(person3);
//        personRepository.save(person4);
//
//        Venue venue1 = new Venue("Highbury");
//        Venue venue2 = new Venue("Old Trafford");
//        Venue venue3 = new Venue("Wembley");
//        Venue venue4 = new Venue("Ibrox Stadium");
//        venueRepository.save(venue1);
//        venueRepository.save(venue2);
//        venueRepository.save(venue3);
//        venueRepository.save(venue4);
//
//        Team team1 = new Team("Arsenal", "Gunners", venue1);
//        Team team2 = new Team("Manchester", "ManU", venue2);
//        Team team3 = new Team("Chelsea", "Blues", venue3);
//        Team team4 = new Team("Glasgow Rangers", "The Teddy Bears", venue4);
//        team1.addPlayer(person1);
//        team1.addPlayer(person2);
//        team2.addPlayer(person3);
//        team2.addPlayer(person4);
//        teamRepository.save(team1);
//        teamRepository.save(team2);
//        teamRepository.save(team3);
//        teamRepository.save(team4);
//
//        Tournament tournament1 = new Tournament("Premier League", football);
////        tournament1.addTeam(team1);
////        tournament1.addTeam(team2);
////        tournament1.addTeam(team3);
////        tournament1.addTeam(team4);
//        tournamentRepository.save(tournament1);
//
////        Date scoreTime1 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
////        Date scoreTime2 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
////        Date scoreTime3 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
////        Date scoreTime4 = new GregorianCalendar(2020, Calendar.AUGUST, 30).getTime();
//
//        TeamMatch teamMatch1 = new TeamMatch(team1, team2, venue1);
//        teamMatchRepository.save(teamMatch1);
//        tournament1.addMatch(teamMatch1);
//
//        ScoreEvent scoreEvent1 = new ScoreEvent(person1, 1, 20, teamMatch1);
//        ScoreEvent scoreEvent2 = new ScoreEvent(person4, 1, 31, teamMatch1);
//        ScoreEvent scoreEvent3 = new ScoreEvent(person3, 1, 76, teamMatch1);
//        ScoreEvent scoreEvent4 = new ScoreEvent(person4, 1, 89, teamMatch1);
//
//        scoreEventRepository.save(scoreEvent1);
//        scoreEventRepository.save(scoreEvent2);
//        scoreEventRepository.save(scoreEvent3);
//        scoreEventRepository.save(scoreEvent4);
//        teamMatch1.addScoreEvent(scoreEvent1);
//        teamMatch1.addScoreEvent(scoreEvent2);
//        teamMatch1.addScoreEvent(scoreEvent3);
//        teamMatch1.addScoreEvent(scoreEvent4);
//        teamMatchRepository.save(teamMatch1);
//        teamMatch1.setCompleted(true);
//        teamMatchRepository.save(teamMatch1);
//
//
//        // nhl
//        Date date20 = new GregorianCalendar(1995, Calendar.FEBRUARY, 25).getTime();
//        Date date21 = new GregorianCalendar(1997, Calendar.JUNE, 20).getTime();
//
//        Person person20 = new Person("Marian", "Hossa", date20, slo);
//        Person person21 = new Person("Auston", "Matthews", date21, can);
//        personRepository.save(person20);
//        personRepository.save(person21);
//        Venue venue20 = new Venue("Wells Fargo Center");
//        Venue venue21 = new Venue("Air Canada Centre");
//        venueRepository.save(venue20);
//        venueRepository.save(venue21);
//
//        Team team20 = new Team("Philadelphia", "PHI", venue20);
//        Team team21= new Team("Toronto", "TOR", venue21);
//        team20.addPlayer(person20);
//        team21.addPlayer(person21);
//        teamRepository.save(team20);
//        teamRepository.save(team21);
//
//        Tournament tournament2 = new Tournament("NHL", iceHockey);
////        tournament2.addTeam(team20);
////        tournament2.addTeam(team21);
//        tournamentRepository.save(tournament2);

    }

}
