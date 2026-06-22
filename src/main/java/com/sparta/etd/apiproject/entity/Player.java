package com.sparta.etd.apiproject.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PlayerID", nullable = false)
    private int playerID;

    @Column(name = "Name", length = 50)
    private String playerName;

    @Column(name = "Email", length = 50)
    private String email;

    @Column(name = "JoinDate")
    private LocalDate joinDate;

    @Column(name = "Level")
    private int playerLevel;

    @ManyToMany(mappedBy = "players")
    @JsonIgnore
    private List<Tournament> tournaments;

    public Player(String playerName, String email, LocalDate joinDate, int playerLevel) {
        this.playerName = playerName;
        this.email = email;
        this.joinDate = joinDate;
        this.playerLevel = playerLevel;
    }

    public Player() {
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}
