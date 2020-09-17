package com.codeclan.example.sports_manager_project.models;
import org.hibernate.annotations.Table;
import javax.persistence.*;

@Entity
@Table(name = "venues")
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public Venue(String name) {
        this.name = name;
    }
    public Venue() {
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
