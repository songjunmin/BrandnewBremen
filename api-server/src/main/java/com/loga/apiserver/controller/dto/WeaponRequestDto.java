package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.AttackType;
import com.loga.apiserver.domain.Weapon;
import com.loga.apiserver.domain.WeaponType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class WeaponRequestDto {
    private AttackType attackType;
    private WeaponType weaponType;
    private int physicalAp;
    private int magicalAp;
    private double attackCoefficient;
    private int level;

    public Weapon toEntity() {
        return Weapon.builder().attackType(attackType)
                .weaponType(weaponType)
                .physicalAp(physicalAp)
                .magicalAp(magicalAp)
                .attackCoefficient(attackCoefficient)
                .level(level).build();
    }
}
