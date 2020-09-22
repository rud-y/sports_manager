package com.codeclan.example.sports_manager_project.models;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String name;

    @ManyToOne
    @JoinColumn(name = "sport_id", nullable = false)
    @JsonIgnoreProperties({"tournaments"})
    private Sport sport;

    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "tournaments_teams",
            joinColumns = {@JoinColumn(name = "tournament_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "team_id", nullable = false, updatable = false)}
    )
    private List<Team> teams;

    @OneToMany(mappedBy = "tournament")//
    @JsonIgnoreProperties({"tournament"})
    private List<TeamMatch> matches;

    public Tournament(String name, Sport sport) {
        this.name = name;
        this.sport = sport;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
    }
    public Tournament() {
    }

    public TournamentTable generateTable() {
        TournamentTable table = new TournamentTable(this.matches);
        table.calculate();
        return table;
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
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
