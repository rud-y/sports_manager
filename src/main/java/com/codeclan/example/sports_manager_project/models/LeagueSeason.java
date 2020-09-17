package com.codeclan.example.sports_manager_project.models;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Table;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "leagueSeasons")
public class LeagueSeason {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Sport sport;
    @Column
    private String name;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnoreProperties({leagueSeasons})
    @JoinTable(
            name = "leagueSeasons_teams",
            joinColumns = {@JoinColumn(name = "leagueSeason_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    private List<Team> teams;

    @OneToMany(mappedBy = "leagueSeason")
    @JsonIgnoreProperties({"leagueSeason"})
    private List<Match> matches;


    public LeagueSeason(Sport sport, String name, List<Team> teams, List<Match> matches) {
        this.sport = sport;
        this.name = name;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }
    public LeagueSeason() {
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

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
}
