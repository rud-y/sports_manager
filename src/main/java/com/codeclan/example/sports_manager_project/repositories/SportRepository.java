package com.codeclan.example.sports_manager_project.repositories;

import com.codeclan.example.sports_manager_project.models.Sport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportRepository extends JpaRepository<Sport, Long> {

}
