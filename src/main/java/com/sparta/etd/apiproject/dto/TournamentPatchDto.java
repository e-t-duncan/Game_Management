package com.sparta.etd.apiproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public class TournamentPatchDto {


    private String tournamentName;
    private LocalDate startDate;
    @Schema(defaultValue = "")
    private Integer maxPlayers;

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

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
