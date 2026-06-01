package com.sparta.etd.apiproject.service;

import com.sparta.etd.apiproject.dto.TournamentDto;
import com.sparta.etd.apiproject.dto.TournamentMapper;
import com.sparta.etd.apiproject.entity.Tournament;
import com.sparta.etd.apiproject.repository.TournamentRepository;
import org.springframework.stereotype.Service;

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
                                          TournamentDto tournamentDto) {

        Tournament tournament = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Could not find tournament by that id"));

        tournament.setTournamentName(tournamentDto.getTournamentName());
        tournament.setStartDate(tournamentDto.getStartDate());
        tournament.setMaxPlayers(tournamentDto.getMaxPlayers());

        Tournament updated = repository.save(tournament);

        return mapper.toDTO(updated);
    }
}