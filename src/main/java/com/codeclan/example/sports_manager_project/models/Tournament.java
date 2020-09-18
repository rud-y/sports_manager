package com.codeclan.example.sports_manager_project.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Sport sport;
    @Column
    private String name;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonBackReference
    @JoinTable(
            name = "tournaments_teams",
            joinColumns = {@JoinColumn(name = "tournament_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    private List<Team> teams;

    @OneToMany(mappedBy = "tournament")
    @JsonIgnoreProperties({"tournament"})
    private List<TeamMatch> matches;


    public Tournament(Sport sport, String name) {
        this.sport = sport;
        this.name = name;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }
    public Tournament() {
    }

    public void addTeam(Team team) {
        this.teams.add(team);
    }
    public void addMatch(TeamMatch match) {
        this.matches.add(match);
    }



    public Long getId() {
        return id;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<TeamMatch> getMatches() {
        return matches;
    }

    public void setMatches(List<TeamMatch> matches) {
        this.matches = matches;
    }
}
