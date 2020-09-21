package com.codeclan.example.sports_manager_project.repositories;

import com.codeclan.example.sports_manager_project.models.SportClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SportClassRepository extends JpaRepository<SportClass, Long> {

}
