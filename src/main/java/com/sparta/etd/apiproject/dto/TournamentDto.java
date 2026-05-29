package com.sparta.etd.apiproject.dto;

import java.time.LocalDate;

public class TournamentDto {

    private Integer tournamentID;
    private String tournamentName;
    private LocalDate startDate;
    private Integer maxPlayers;


    public TournamentDto() {
    }

    public TournamentDto(Integer tournamentID, String tournamentName, LocalDate startDate, Integer maxPlayers) {
        this.tournamentID = tournamentID;
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.maxPlayers = maxPlayers;
    }

    public Integer getTournamentID() {
        return tournamentID;
    }

    public void setTournamentID(Integer tournamentID) {
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

    public Integer getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(Integer maxPlayers) {
        this.maxPlayers = maxPlayers;
    }
}
