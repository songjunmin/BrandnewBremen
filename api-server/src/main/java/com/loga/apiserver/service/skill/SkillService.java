package com.loga.apiserver.service.skill;

import com.loga.apiserver.domain.Skill;

public interface SkillService {
    Long save(Long playerId, Long weaponId, Skill skill);
    Skill findById(Long id);
}
