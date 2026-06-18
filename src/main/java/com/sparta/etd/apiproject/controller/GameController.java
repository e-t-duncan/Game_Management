package com.sparta.etd.apiproject.controller;


import com.sparta.etd.apiproject.dto.GameDto;
import com.sparta.etd.apiproject.dto.GamePatchDto;
import com.sparta.etd.apiproject.service.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

@RestController
@RequestMapping("/api/games")
@CrossOrigin(origins = "http://localhost:5173")
public class GameController {

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    @Operation(summary = "Get all games", description = "Provides a list of all games")
    @GetMapping
    public ResponseEntity<List<GameDto>> getAllGames() {
        var games = service.getAllGames();
        return ResponseEntity.ok().body(games);
    }

    @Operation(summary = "Get game by Id", description = "If a correct id is entered, returns a game")
    @GetMapping("/{id}")
    public ResponseEntity<GameDto> getGameById(@PathVariable int id) {
        var game = service.getGameByID(id);
        if (game != null) {
            return ResponseEntity.ok().body(game);
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Add a new game", description = "If a game has all the correct information, adds them")
    @PostMapping
    public ResponseEntity<GameDto> createGame(@RequestBody GameDto gameDto) {
        GameDto savedGame = service.saveGame(gameDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedGame);
    }

    @Operation(summary = "Updates an existing game", description = "If a game is present update it")
    @PatchMapping("/{id}")
    public ResponseEntity<GameDto> updateGame(
            @PathVariable int id,
            @RequestBody GamePatchDto gameDto
    ) {

        GameDto updatedGame = service.updateGame(id, gameDto);

        if (updatedGame == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedGame);
    }

    @Operation(
            summary = "Delete a game",
            description = "Deletes the game associated with the provided game ID."
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGame(@PathVariable int id) {

        boolean deleted = service.deleteGame(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

}
