package com.codeclan.example.sports_manager_project.repositories;
import com.codeclan.example.sports_manager_project.models.Country;
import com.codeclan.example.sports_manager_project.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

//     List<Person> findByLastName(String surname);

    List<Person>findByNationality(Country nationality);
}
