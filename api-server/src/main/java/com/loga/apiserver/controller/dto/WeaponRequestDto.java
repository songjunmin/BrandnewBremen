package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.AttackType;
import com.loga.apiserver.domain.Weapon;
import com.loga.apiserver.domain.WeaponType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WeaponRequestDto {
    @NotEmpty
    @Schema(description = "weapon name", example = "axe")
    private String weaponName;
    @ValidEnum(enumClass = AttackType.class)
    @Schema(description = "weapon attackType", example = "PHYSICAL")
    private AttackType attackType;
    @ValidEnum(enumClass = WeaponType.class)
    @Schema(description = "weapon type", example = "AXE")
    private WeaponType weaponType;
    @NotNull
    @Schema(description = "weapon physicalAp", example = "10")
    private int physicalAp;
    @NotNull
    @Schema(description = "weapon magicalAp", example = "0")
    private int magicalAp;
    @NotNull
    @Schema(description = "weapon attackCoefficient", example = "1")
    private double attackCoefficient;
    @NotNull
    @Schema(description = "weapon level", example = "1")
    private int level;

    public Weapon toEntity() {
        return Weapon.builder()
                .weaponName(weaponName)
                .attackType(attackType)
                .weaponType(weaponType)
                .physicalAp(physicalAp)
                .magicalAp(magicalAp)
                .attackCoefficient(attackCoefficient)
                .level(level).build();
    }
}
