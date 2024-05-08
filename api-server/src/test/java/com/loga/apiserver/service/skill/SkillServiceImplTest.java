package com.loga.apiserver.service.skill;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.domain.*;
import com.loga.apiserver.service.player.PlayerService;
import com.loga.apiserver.service.weapon.WeaponService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = ApiServerApplication.class)
@ExtendWith(SpringExtension.class)
@Transactional
class SkillServiceImplTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    WeaponService weaponService;
    @Autowired
    SkillService skillService;

    @Test
    void skillSave() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Weapon staff = new Weapon(AttackType.MAGICAL, WeaponType.STAFF, 0, 20, 2, 1);
        Long savedWeaponId = weaponService.save(savedPlayerId, staff);

        Skill skill = new Skill(150, 30, 75, 5);
        Long savedSkillId = skillService.save(savedPlayerId, savedWeaponId, skill);
        Skill foundSkill = skillService.findById(savedSkillId);

        Assertions.assertThat(savedSkillId).isEqualTo(foundSkill.getId());
    }
}