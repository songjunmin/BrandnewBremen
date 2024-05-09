package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Player;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlayerRequestDto {
    @NotNull
    @Schema(description = "player hp", example = "100")
    private int hp;
    @NotNull
    @Schema(description = "player mp", example = "50")
    private int mp;
    @NotNull
    @Schema(description = "player stamina", example = "50")
    private int stamina;
    @NotNull
    @Schema(description = "player physicalAp", example = "10")
    private int physicalAp;
    @NotNull
    @Schema(description = "player magicalAp", example = "10")
    private int magicalAp;

    public Player toEntity() {
        return Player.builder()
                .hp(hp)
                .mp(mp)
                .stamina(stamina)
                .physicalAp(physicalAp).
                magicalAp(magicalAp).build();
    }
}
