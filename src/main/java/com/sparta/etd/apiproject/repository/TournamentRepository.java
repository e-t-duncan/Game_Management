package com.sparta.etd.apiproject.repository;

import com.sparta.etd.apiproject.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, Integer> {
}
