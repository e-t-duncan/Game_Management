package com.sparta.etd.apiproject.modelAssembler;

import com.sparta.etd.apiproject.controller.PlayerController;
import com.sparta.etd.apiproject.dto.PlayerDto;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class PlayerModelAssembler
        implements RepresentationModelAssembler<PlayerDto, EntityModel<PlayerDto>> {

    @Override
    public EntityModel<PlayerDto> toModel(PlayerDto player) {

        return EntityModel.of(
                player,

                linkTo(methodOn(PlayerController.class)
                        .getPlayerById(player.getPlayerID()))
                        .withSelfRel(),

                linkTo(methodOn(PlayerController.class)
                        .getAllPlayers())
                        .withRel("allPlayers")
        );
    }
}