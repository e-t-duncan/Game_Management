package com.sparta.etd.apiproject.repository;

import com.sparta.etd.apiproject.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
