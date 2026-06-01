package com.sparta.etd.apiproject.dto;

import com.sparta.etd.apiproject.entity.Game;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface GameMapper {

    GameDto toDTO(Game game);

    Game toEntity(GameDto gameDto);

}
