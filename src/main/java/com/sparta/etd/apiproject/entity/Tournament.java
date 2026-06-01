package com.sparta.etd.apiproject.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TournamentID", nullable = false)
    private int tournamentID;

    @Column(name = "Name", length = 50)
    private String tournamentName;

    @Column(name = "StartDate")
    private LocalDate startDate;

    @Column(name = "MaxPlayers")
    private int maxPlayers;

    @ManyToOne
    @JoinColumn(name = "GameID", nullable = true)
    private Game game;

    @ManyToMany
    @JoinTable(
            name = "tournament_players",            // Join table name
            joinColumns = @JoinColumn(name = "TournamentID"), // FK referencing Tournament
            inverseJoinColumns = @JoinColumn(name = "PlayerID") // FK referencing Player
    )
    @JsonManagedReference
    private List<Player> players;

    public Tournament() {
    }

    public Tournament(String tournamentName, LocalDate startDate, int maxPlayers, Game game) {
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.maxPlayers = maxPlayers;
        this.game = game;
    }

    public int getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(int tournamentID) {
        this.tournamentID = tournamentID;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}