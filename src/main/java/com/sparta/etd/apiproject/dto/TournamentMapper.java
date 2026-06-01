package com.sparta.etd.apiproject.dto;


import com.sparta.etd.apiproject.entity.Tournament;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TournamentMapper {

    TournamentDto toDTO(Tournament tournament);

    Tournament toEntity(TournamentDto tournamentDto);

}
