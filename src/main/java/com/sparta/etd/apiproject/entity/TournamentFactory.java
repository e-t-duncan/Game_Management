package com.sparta.etd.apiproject.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class TournamentFactory {

    public Tournament createTournament(String tournamentName, LocalDate startDate, int maxPlayers, Game game){
        return new Tournament(tournamentName, startDate, maxPlayers, game);
    }


}
