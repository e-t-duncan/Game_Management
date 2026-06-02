package com.sparta.etd.apiproject.entity;

import java.time.LocalDate;

public class GameFactory {

    public Game createGame(String gameTitle, String gameGenre, LocalDate releaseDate, String platform){

        return new Game(gameTitle, gameGenre, releaseDate, platform);
    }
}
