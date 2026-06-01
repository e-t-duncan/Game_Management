package com.sparta.etd.apiproject.service;


import com.sparta.etd.apiproject.dto.GameDto;
import com.sparta.etd.apiproject.dto.GameMapper;
import com.sparta.etd.apiproject.entity.Game;
import com.sparta.etd.apiproject.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    private final GameMapper mapper;
    private final GameRepository repository;

    public GameService(GameMapper mapper, GameRepository repository){
        this.repository = repository;
        this.mapper = mapper;
    }

    //get all method
    public List<GameDto> getAllGames(){
        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public GameDto getGameByID(int id){
        return repository.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    public GameDto saveGame(GameDto gameDto) {
        Game game = mapper.toEntity(gameDto);
        Game saved = repository.save(game);
        return mapper.toDTO(saved);
    }

    public boolean deleteGame(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public GameDto updateGame(int id, GameDto gameDto){

        Game game = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Could not find game by that id"));

        game.setGameTitle(gameDto.getGameTitle());
        game.setGameGenre(gameDto.getGameGenre());
        game.setPlatform(gameDto.getPlatform());
        game.setReleaseDate(gameDto.getReleaseDate());

        Game updated = repository.save(game);

        return mapper.toDTO(updated);
    }

}
