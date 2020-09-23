package com.codeclan.example.sports_manager_project.repositories;
import com.codeclan.example.sports_manager_project.models.Team;
import com.codeclan.example.sports_manager_project.models.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TournamentRepository extends JpaRepository<Tournament, Long> {
//    List<Tournament> findByTeamsName(String name);
    List<Team> findTeamsById(long id);
}

