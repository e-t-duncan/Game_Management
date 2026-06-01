package com.sparta.etd.apiproject.dto;

import com.sparta.etd.apiproject.entity.Player;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PlayerMapper {

    PlayerDto toDTO(Player player);

    Player toEntity(PlayerDto playerDto);
}
