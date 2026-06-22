package com.sparta.etd.apiproject.dto;


import com.sparta.etd.apiproject.entity.Player;
import com.sparta.etd.apiproject.entity.Tournament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TournamentMapper {


    @Mapping(
            source = "game.gameID",
            target = "gameID"
    )
    @Mapping(
            source = "players",
            target = "playerIDs"
    )
    TournamentDto toDTO(Tournament tournament);

    @Mapping(
            target = "game",
            ignore = true
    )
    @Mapping(
            target = "players",
            ignore = true
    )
    Tournament toEntity(TournamentDto dto);

    default List<Integer> mapPlayers(List<Player> players) {

        if(players == null) {
            return null;
        }

        return players.stream()
                .map(Player::getPlayerID)
                .toList();
    }

}
