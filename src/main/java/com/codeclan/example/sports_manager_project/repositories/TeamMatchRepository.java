package com.codeclan.example.sports_manager_project.repositories;
import com.codeclan.example.sports_manager_project.models.TeamMatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamMatchRepository extends JpaRepository<TeamMatch, Long> {

    List<TeamMatch> findByScoreEventsPersonLastName(String scorer);

    List<TeamMatch> findByCompleted(Boolean completed);
}
