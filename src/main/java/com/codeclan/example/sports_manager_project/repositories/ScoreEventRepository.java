package com.codeclan.example.sports_manager_project.repositories;

import com.codeclan.example.sports_manager_project.models.ScoreEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScoreEventRepository extends JpaRepository<ScoreEvent, Long> {

}
