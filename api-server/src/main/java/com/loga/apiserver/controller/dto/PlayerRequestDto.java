package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class PlayerRequestDto {
    private int hp;
    private int mp;
    private int stamina;
    private int physicalAp;
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
