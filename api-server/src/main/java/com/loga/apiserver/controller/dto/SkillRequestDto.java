package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Skill;
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
public class SkillRequestDto {
    @NotNull
    @Schema(description = "skill name", example = "iceBall")
    private String skillName;
    @NotNull
    @Schema(description = "skill range", example = "150")
    private int range;
    @NotNull
    @Schema(description = "skill coolTime", example = "10")
    private int coolTime;
    @NotNull
    @Schema(description = "skill mpConsumption", example = "30")
    private int mpConsumption;
    @NotNull
    @Schema(description = "skill coefficient", example = "2")
    private double skillCoefficient;

    public Skill toEntity() {
        return Skill.builder()
                .skillName(skillName)
                .range(range)
                .coolTime(coolTime)
                .mpConsumption(mpConsumption)
                .skillCoefficient(skillCoefficient).build();
    }
}
