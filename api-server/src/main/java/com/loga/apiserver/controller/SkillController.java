package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.SkillRequestDto;
import com.loga.apiserver.service.skill.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SkillController {
    private final SkillService skillService;

    @Autowired
    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/players/{playerId}/weapons/{weaponId}/skills")
    public Long save(@PathVariable("playerId") Long playerId,
                     @PathVariable("weaponId") Long weaponId,
                     @RequestBody SkillRequestDto skillRequestDto) {
        return skillService.save(playerId, weaponId, skillRequestDto.toEntity());
    }
}
