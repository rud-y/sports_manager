package com.codeclan.example.sports_manager_project.repositories;
import com.codeclan.example.sports_manager_project.models.Team;
import com.codeclan.example.sports_manager_project.models.Venue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByVenueName(String venue);
}
