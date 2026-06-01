package com.sparta.etd.apiproject.service;

import com.sparta.etd.apiproject.dto.TournamentDto;
import com.sparta.etd.apiproject.dto.TournamentMapper;
import com.sparta.etd.apiproject.dto.TournamentPatchDto;
import com.sparta.etd.apiproject.entity.Tournament;
import com.sparta.etd.apiproject.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private final TournamentMapper mapper;
    private final TournamentRepository repository;

    public TournamentService(TournamentMapper mapper,
                             TournamentRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    // Get all tournaments
    public List<TournamentDto> getAllTournaments() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get tournament by ID
    public TournamentDto getTournamentByID(int id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    // Save tournament
    public TournamentDto saveTournament(TournamentDto tournamentDto) {
        Tournament tournament = mapper.toEntity(tournamentDto);
        Tournament saved = repository.save(tournament);
        return mapper.toDTO(saved);
    }

    // Delete tournament
    public boolean deleteTournament(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update tournament
    public TournamentDto updateTournament(int id,
                                          TournamentPatchDto dto) {

        Tournament tournament = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find tournament by that id"));

        if (dto.getTournamentName() != null && !dto.getTournamentName().equals("string")) {
            tournament.setTournamentName(dto.getTournamentName());
        }

        if (dto.getStartDate() != null && !dto.getStartDate().equals(LocalDate.now())) {
            tournament.setStartDate(dto.getStartDate());
        }

        if (dto.getMaxPlayers() != null) {
            tournament.setMaxPlayers(dto.getMaxPlayers());
        }

        Tournament updated = repository.save(tournament);
        return mapper.toDTO(updated);
    }
}