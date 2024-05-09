package com.loga.apiserver.service.skill;

import com.loga.apiserver.domain.*;
import com.loga.apiserver.exception.NoSuchSkillException;
import com.loga.apiserver.exception.NoSuchWeaponException;
import com.loga.apiserver.exception.SkillAlreadySavedException;
import com.loga.apiserver.repository.PlayerSkillRepository;
import com.loga.apiserver.repository.SkillRepository;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkillServiceImpl implements SkillService {
    private final PlayerService playerService;
    private final SkillRepository skillRepository;
    private final PlayerSkillRepository playerSkillRepository;

    @Autowired
    public SkillServiceImpl(PlayerService playerService, SkillRepository skillRepository, PlayerSkillRepository playerSkillRepository) {
        this.playerService = playerService;
        this.skillRepository = skillRepository;
        this.playerSkillRepository = playerSkillRepository;
    }

    @Override
    @Transactional
    public Long save(Long playerId, Long weaponId, Skill skill) {
        Player foundPlayer = playerService.findById(playerId);
        Weapon foundWeapon = foundPlayer.getInventory().getInventoryWeapons()
                .stream().map(InventoryWeapon::getWeapon)
                .filter(w -> w.getId().equals(weaponId))
                .findAny().orElseThrow(() -> new NoSuchWeaponException("무기를 찾을 수 없습니다."));
        boolean isPresent = foundWeapon.getSkills().stream()
                .anyMatch(s -> s.getSkillName().equals(skill.getSkillName()));
        if (isPresent) {
            throw new SkillAlreadySavedException("이미 저장된 스킬 입니다.");
        }
        skillRepository.save(skill);
        foundWeapon.addSkill(skill);
        PlayerSkill playerSkill = new PlayerSkill();
        playerSkill.setSkill(skill);
        foundPlayer.addPlayerSkill(playerSkill);
        playerSkillRepository.save(playerSkill);
        return skill.getId();
    }

    @Override
    public Skill findById(Long id) {
        return skillRepository.findById(id).orElseThrow(() -> new NoSuchSkillException("스킬을 찾을 수 없습니다."));
    }
}
