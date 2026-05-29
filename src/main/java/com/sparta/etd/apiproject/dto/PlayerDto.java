package com.sparta.etd.apiproject.dto;

import java.time.LocalDate;

public class PlayerDto {

    private Integer playerID;
    private String playerName;
    private String email;
    private LocalDate joinDate;
    private Integer playerLevel;

    public PlayerDto(Integer playerID, String playerName, String email, LocalDate joinDate, int playerLevel) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.email = email;
        this.joinDate = joinDate;
        this.playerLevel = playerLevel;
    }

    public PlayerDto() {
    }

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
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
}
