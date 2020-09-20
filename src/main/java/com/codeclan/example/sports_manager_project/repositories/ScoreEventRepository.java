package com.codeclan.example.sports_manager_project.repositories;

import com.codeclan.example.sports_manager_project.models.Person;
import com.codeclan.example.sports_manager_project.models.ScoreEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScoreEventRepository extends JpaRepository<ScoreEvent, Long> {

    List<ScoreEvent> findByPersonLastName(String player);
}
