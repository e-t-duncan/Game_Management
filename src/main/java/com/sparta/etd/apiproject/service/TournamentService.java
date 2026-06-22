package com.sparta.etd.apiproject.service;

import com.sparta.etd.apiproject.dto.TournamentDto;
import com.sparta.etd.apiproject.dto.TournamentMapper;
import com.sparta.etd.apiproject.dto.TournamentPatchDto;
import com.sparta.etd.apiproject.entity.Game;
import com.sparta.etd.apiproject.entity.Player;
import com.sparta.etd.apiproject.entity.Tournament;
import com.sparta.etd.apiproject.repository.GameRepository;
import com.sparta.etd.apiproject.repository.PlayerRepository;
import com.sparta.etd.apiproject.repository.TournamentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {

    private final TournamentMapper mapper;
    private final TournamentRepository repository;
    private final PlayerRepository playerRepository;
    private final GameRepository gameRepository;

    public TournamentService(TournamentMapper mapper, TournamentRepository repository, PlayerRepository playerRepository, GameRepository gameRepository) {
        this.mapper = mapper;
        this.repository = repository;
        this.playerRepository = playerRepository;
        this.gameRepository = gameRepository;
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


        if(tournamentDto.getGameID() != null){

            Game game = gameRepository
                    .findById(tournamentDto.getGameID())
                    .orElseThrow();

            tournament.setGame(game);
        }


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

    public TournamentDto updateTournament(int id, TournamentPatchDto dto) {

        Tournament tournament = repository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Could not find tournament"));


        if(dto.getTournamentName() != null) {
            tournament.setTournamentName(dto.getTournamentName());
        }


        if(dto.getStartDate() != null) {
            tournament.setStartDate(dto.getStartDate());
        }


        if(dto.getMaxPlayers() != null) {

            if(dto.getMaxPlayers() < tournament.getPlayers().size()) {
                throw new RuntimeException(
                        "Max players cannot be lower than current enrolled players");
            }

            tournament.setMaxPlayers(dto.getMaxPlayers());
        }


        if(dto.getGameID() != null) {

            Game game = gameRepository.findById(dto.getGameID())
                    .orElseThrow(() ->
                            new RuntimeException("Game not found"));

            tournament.setGame(game);
        }


        Tournament updated = repository.save(tournament);

        return mapper.toDTO(updated);
    }

    @Transactional
    public TournamentDto enrollPlayer(int tournamentId, int playerId) {

        Tournament tournament = repository.findById(tournamentId)
                .orElseThrow(() ->
                        new RuntimeException("Tournament not found"));

        Player player = playerRepository.findById(playerId)
                .orElseThrow(() ->
                        new RuntimeException("Player not found"));


        if(tournament.getPlayers().contains(player)) {
            throw new RuntimeException("Player already enrolled");
        }


        if(tournament.getPlayers().size() >= tournament.getMaxPlayers()) {
            throw new RuntimeException("Tournament is full");
        }


        tournament.addPlayer(player);
        player.getTournaments().add(tournament);


        Tournament saved = repository.save(tournament);

        return mapper.toDTO(saved);
    }

    public TournamentDto addGame(int tournamentId, int gameId) {

        Tournament tournament = repository.findById(tournamentId).orElseThrow(() -> new RuntimeException("Tournament not found"));

        Game game = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

        tournament.setGame(game);

        return mapper.toDTO(repository.save(tournament));
    }
}