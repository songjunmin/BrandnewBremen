package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Skill;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SkillRequestDto {
    @NotEmpty
    @Schema(description = "skill range", example = "150")
    private int range;
    @NotEmpty
    @Schema(description = "skill coolTime", example = "10")
    private int coolTime;
    @NotEmpty
    @Schema(description = "skill mpConsumption", example = "30")
    private int mpConsumption;
    @NotEmpty
    @Schema(description = "skill coefficient", example = "2")
    private double skillCoefficient;

    public Skill toEntity() {
        return Skill.builder().range(range)
                .coolTime(coolTime)
                .mpConsumption(mpConsumption)
                .skillCoefficient(skillCoefficient).build();
    }
}
