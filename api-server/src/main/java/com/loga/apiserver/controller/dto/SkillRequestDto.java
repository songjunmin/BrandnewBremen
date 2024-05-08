package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class SkillRequestDto {
    private int range;
    private int coolTime;
    private int mpConsumption;
    private double skillCoefficient;

    public Skill toEntity() {
        return Skill.builder().range(range)
                .coolTime(coolTime)
                .mpConsumption(mpConsumption)
                .skillCoefficient(skillCoefficient).build();
    }
}
