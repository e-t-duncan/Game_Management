package com.sparta.etd.apiproject.service;

import com.sparta.etd.apiproject.dto.PlayerDto;
import com.sparta.etd.apiproject.dto.PlayerMapper;
import com.sparta.etd.apiproject.dto.PlayerPatchDto;
import com.sparta.etd.apiproject.entity.Game;
import com.sparta.etd.apiproject.entity.Player;
import com.sparta.etd.apiproject.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerService {

    private final PlayerMapper mapper;
    private final PlayerRepository repository;

    public PlayerService(PlayerMapper mapper, PlayerRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    // Get all players
    public List<PlayerDto> getAllPlayers() {
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    // Get player by ID
    public PlayerDto getPlayerByID(int id) {
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    // Save player
    public PlayerDto savePlayer(PlayerDto playerDto) {
        Player player = mapper.toEntity(playerDto);
        Player saved = repository.save(player);
        return mapper.toDTO(saved);
    }

    // Delete player
    public boolean deletePlayer(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update player
    public PlayerDto updatePlayer(int id, PlayerPatchDto dto) {
        Player player = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found"));

        if (dto.getPlayerName() != null && !dto.getPlayerName().equals("string")) {
            player.setPlayerName(dto.getPlayerName());
        }

        if (dto.getPlayerLevel() != null) {
            player.setPlayerLevel(dto.getPlayerLevel());
        }

        if (dto.getEmail() != null && !dto.getEmail().equals("string")) {
            player.setEmail(dto.getEmail());
        }

        if (dto.getJoinDate() != null || dto.getJoinDate().equals(LocalDate.now())){
            player.setJoinDate(dto.getJoinDate());
        }

        return mapper.toDTO(repository.save(player));
    }
}