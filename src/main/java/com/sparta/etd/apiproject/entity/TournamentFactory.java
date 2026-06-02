package com.sparta.etd.apiproject.entity;

import java.time.LocalDate;

public class TournamentFactory {

    public Tournament createTournament(String tournamentName, LocalDate startDate, int maxPlayers, Game game){
        return new Tournament(tournamentName, startDate, maxPlayers, game);
    }


}
