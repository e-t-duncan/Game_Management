package com.sparta.etd.apiproject.entity;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tournaments")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TournamentID", nullable = false)
    private int tournamentID;

    @Column(name = "Name", length = 50)
    private String tournamentName;

    @Column(name = "StartDate", length = 10)
    private LocalDate startDate;

    @Column(name = "MaxPlayers", length = 100)
    private int maxPlayers;

    @ManyToOne
    @JoinColumn(name = "GameID", nullable = false)
    private Game game;

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
}