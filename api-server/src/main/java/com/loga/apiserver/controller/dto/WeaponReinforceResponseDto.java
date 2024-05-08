package com.loga.apiserver.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class WeaponReinforceResponseDto {
    private int ap;
    private double attackCoefficient;
    private int level;
}
