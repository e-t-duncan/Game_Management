package com.sparta.etd.apiproject.repository;

import com.sparta.etd.apiproject.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Integer> {
}
