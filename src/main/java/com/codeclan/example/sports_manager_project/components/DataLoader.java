package com.codeclan.example.sports_manager_project.components;
import com.codeclan.example.sports_manager_project.models.Tournament;
import com.codeclan.example.sports_manager_project.repositories.PersonRepository;
import com.codeclan.example.sports_manager_project.repositories.TeamRepository;
import com.codeclan.example.sports_manager_project.repositories.TournamentRepository;
import com.codeclan.example.sports_manager_project.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.JoinColumn;

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

    public DataLoader() {}

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person bellingham = new Person();
        Person ozil = new Person();
        Person messi = new Person();
        Person hamsik = new Person();

        Team arsenal = new Team();
        Team spartak = new Team();
        Team stars = new Team();



    }

}
