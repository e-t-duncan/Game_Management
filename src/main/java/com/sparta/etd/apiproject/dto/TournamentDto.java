package com.sparta.etd.apiproject.dto;

import java.time.LocalDate;
import java.util.List;

public class TournamentDto {

    private Integer tournamentID;

    private String tournamentName;

    private LocalDate startDate;

    private Integer maxPlayers;

    // Game assigned to tournament
    private Integer gameID;

    // Players enrolled in tournament
    private List<Integer> playerIDs;


    public TournamentDto() {
    }


    public TournamentDto(
            Integer tournamentID,
            String tournamentName,
            LocalDate startDate,
            Integer maxPlayers,
            Integer gameID,
            List<Integer> playerIDs) {

        this.tournamentID = tournamentID;
        this.tournamentName = tournamentName;
        this.startDate = startDate;
        this.maxPlayers = maxPlayers;
        this.gameID = gameID;
        this.playerIDs = playerIDs;
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


    public Integer getGameID() {
        return gameID;
    }

    public void setGameID(Integer gameID) {
        this.gameID = gameID;
    }


    public List<Integer> getPlayerIDs() {
        return playerIDs;
    }

    public void setPlayerIDs(List<Integer> playerIDs) {
        this.playerIDs = playerIDs;
    }
}