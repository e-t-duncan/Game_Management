package com.sparta.etd.apiproject.controller;

import com.sparta.etd.apiproject.dto.PlayerDto;
import com.sparta.etd.apiproject.dto.PlayerPatchDto;
import com.sparta.etd.apiproject.modelAssembler.PlayerModelAssembler;
import com.sparta.etd.apiproject.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/players")
@CrossOrigin(origins = "http://localhost:5173")
public class PlayerController {

    private final PlayerService service;

    private final PlayerModelAssembler assembler;

    public PlayerController(PlayerService service,
                            PlayerModelAssembler assembler) {

        this.service = service;
        this.assembler = assembler;
    }

    @Operation(summary = "Get all players", description = "Provides a list of all players")
    @GetMapping
    public ResponseEntity<CollectionModel<EntityModel<PlayerDto>>> getAllPlayers() {

        var players = service.getAllPlayers()
                .stream()
                .map(assembler::toModel)
                .toList();

        return ResponseEntity.ok(CollectionModel.of(players));
    }

    @Operation(summary = "Get player by Id", description = "Returns a player if the ID exists")
    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<PlayerDto>> getPlayerById(
            @PathVariable int id) {

        PlayerDto player = service.getPlayerByID(id);

        if (player == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(assembler.toModel(player));
    }

    @Operation(summary = "Create a new player", description = "Adds a new player to the system")
    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        PlayerDto savedPlayer = service.savePlayer(playerDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPlayer);
    }

    @Operation(summary = "Update player", description = "Partially updates an existing player")
    @PatchMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(
            @PathVariable int id,
            @RequestBody PlayerPatchDto playerDto
    ) {

        PlayerDto updatedPlayer = service.updatePlayer(id, playerDto);

        if (updatedPlayer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedPlayer);
    }

    @Operation(summary = "Delete player", description = "Deletes a player by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlayer(@PathVariable int id) {

        boolean deleted = service.deletePlayer(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}