package com.loga.apiserver.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class WeaponReinforceResponseDto {
    @Schema(description = "ap", example = "12")
    private int ap;
    @Schema(description = "attackCoefficient", example = "1.5")
    private double attackCoefficient;
    @Schema(description = "level", example = "2")
    private int level;
}
