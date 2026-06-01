package com.sparta.etd.apiproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class PlayerPatchDto {

    private String playerName;
    private String email;
    private LocalDate joinDate;
    @Schema(defaultValue = "")
    private Integer playerLevel;

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

    public Integer getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(Integer playerLevel) {
        this.playerLevel = playerLevel;
    }
}
