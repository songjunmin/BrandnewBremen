package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.SkillRequestDto;
import com.loga.apiserver.service.skill.SkillService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "SkillController", description = "스킬 저장 기능을 제공하는 컨트롤러")
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "save skill",
                    content = @Content(schema = @Schema(description = "skillId", example = "1"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter",
                    content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PostMapping("/players/{playerId}/weapons/{weaponId}/skills")
    public Long save(@PathVariable("playerId") Long playerId,
                     @PathVariable("weaponId") Long weaponId,
                     @Valid @RequestBody SkillRequestDto skillRequestDto) {
        return skillService.save(playerId, weaponId, skillRequestDto.toEntity());
    }
}
