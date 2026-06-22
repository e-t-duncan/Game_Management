package com.sparta.etd.apiproject.controller;

import com.sparta.etd.apiproject.dto.TournamentDto;
import com.sparta.etd.apiproject.dto.TournamentPatchDto;
import com.sparta.etd.apiproject.service.TournamentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
@CrossOrigin(origins = "http://localhost:5173")
public class TournamentController {

    private final TournamentService service;

    public TournamentController(TournamentService service) {
        this.service = service;
    }

    @Operation(summary = "Get all tournaments", description = "Returns a list of all tournaments")
    @GetMapping
    public ResponseEntity<List<TournamentDto>> getAllTournaments() {
        var tournaments = service.getAllTournaments();
        return ResponseEntity.ok(tournaments);
    }

    @Operation(summary = "Get tournament by Id", description = "Returns a tournament if the ID exists")
    @GetMapping("/{id}")
    public ResponseEntity<TournamentDto> getTournamentById(@PathVariable int id) {
        var tournament = service.getTournamentByID(id);

        if (tournament != null) {
            return ResponseEntity.ok(tournament);
        }

        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Create a new tournament", description = "Adds a new tournament to the system")
    @PostMapping
    public ResponseEntity<TournamentDto> createTournament(@RequestBody TournamentDto tournamentDto) {
        TournamentDto savedTournament = service.saveTournament(tournamentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTournament);
    }

    @Operation(summary = "Update tournament", description = "Partially updates an existing tournament")
    @PatchMapping("/{id}")
    public ResponseEntity<TournamentDto> updateTournament(
            @PathVariable int id,
            @RequestBody TournamentPatchDto tournamentDto
    ) {

        TournamentDto updatedTournament = service.updateTournament(id, tournamentDto);

        if (updatedTournament == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTournament);
    }

    @Operation(summary = "Delete tournament", description = "Deletes a tournament by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable int id) {

        boolean deleted = service.deleteTournament(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    @Operation(
            summary = "Enroll player into tournament",
            description = "Adds a player to a tournament if there is space available"
    )
    @PostMapping("/{tournamentId}/players/{playerId}")
    public ResponseEntity<TournamentDto> enrollPlayer(
            @PathVariable int tournamentId,
            @PathVariable int playerId
    ) {

        TournamentDto updatedTournament =
                service.enrollPlayer(tournamentId, playerId);

        return ResponseEntity.ok(updatedTournament);
    }

    @Operation(
            summary = "Assign game to tournament",
            description = "Sets the game that the tournament will use"
    )
    @PutMapping("/{tournamentId}/game/{gameId}")
    public ResponseEntity<TournamentDto> addGame(
            @PathVariable int tournamentId,
            @PathVariable int gameId
    ) {

        TournamentDto updatedTournament =
                service.addGame(tournamentId, gameId);

        return ResponseEntity.ok(updatedTournament);
    }
}