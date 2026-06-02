package com.sparta.etd.apiproject.config;


import com.sparta.etd.apiproject.entity.*;
import com.sparta.etd.apiproject.repository.GameRepository;
import com.sparta.etd.apiproject.repository.PlayerRepository;
import com.sparta.etd.apiproject.repository.TournamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    @Transactional
    public CommandLineRunner loadData(GameRepository gaRepo, PlayerRepository plRepo, TournamentRepository toRepo, PlayerFactory playerFactory, GameFactory gameFactory, TournamentFactory tournamentFactory) {
        return args -> {
            System.out.println("Data loading running");

            Player p1 = playerFactory.createPlayer("Alice", "alice@gmail.com", LocalDate.of(2024, 1, 15), 50);
            Player p2 = playerFactory.createPlayer("Rob", "rob@gmail.com", LocalDate.of(2026, 6, 2), 1);
            plRepo.saveAll(List.of(p1,p2));

            Game g1 = gameFactory.createGame("FIFA26", "Sport", LocalDate.of(2025, 9, 26), "PS, XBOX, PC");
            Game g2 = gameFactory.createGame("Rainbow 6 Siege", "Action", LocalDate.of(2015, 12, 1), "PS, XBOX, PC");
            gaRepo.saveAll(List.of(g1,g2));

            Tournament t1 = tournamentFactory.createTournament("FIFA Tournament", LocalDate.of(2026, 6, 22), 50, g1);
            Tournament t2 = tournamentFactory.createTournament("Blank Tournament", LocalDate.of(2026, 6, 18), 10, null);
            toRepo.saveAll(List.of(t1, t2));

        };



    }
}
