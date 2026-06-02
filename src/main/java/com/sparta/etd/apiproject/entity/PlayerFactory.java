package com.sparta.etd.apiproject.entity;

import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class PlayerFactory {

    public Player createPlayer(String name, String email, LocalDate joinDate, int level) {
        if (level < 1) {
            level = 1;
        }
        return new Player(name, email, joinDate, level);
    }
}
