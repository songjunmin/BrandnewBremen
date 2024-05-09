package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Player;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class PlayerRequestDto {
    @NotEmpty
    @Schema(description = "player hp", example = "100")
    private int hp;
    @NotEmpty
    @Schema(description = "player mp", example = "50")
    private int mp;
    @NotEmpty
    @Schema(description = "player stamina", example = "50")
    private int stamina;
    @NotEmpty
    @Schema(description = "player physicalAp", example = "10")
    private int physicalAp;
    @NotEmpty
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
