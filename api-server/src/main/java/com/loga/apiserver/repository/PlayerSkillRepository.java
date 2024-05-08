package com.loga.apiserver.repository;

import com.loga.apiserver.domain.PlayerSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSkillRepository extends JpaRepository<PlayerSkill, Long> {
}
