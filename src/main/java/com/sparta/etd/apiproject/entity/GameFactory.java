package com.sparta.etd.apiproject.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class GameFactory {

    public Game createGame(String gameTitle, String gameGenre, LocalDate releaseDate, String platform){

        return new Game(gameTitle, gameGenre, releaseDate, platform);
    }
}
