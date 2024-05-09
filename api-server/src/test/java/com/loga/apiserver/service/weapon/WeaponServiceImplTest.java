package com.loga.apiserver.service.weapon;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.domain.AttackType;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.domain.Weapon;
import com.loga.apiserver.domain.WeaponType;
import com.loga.apiserver.service.player.PlayerService;
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
class WeaponServiceImplTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    WeaponService weaponService;

    @Test
    void weaponSave() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Weapon staff = new Weapon("staff", AttackType.MAGICAL, WeaponType.STAFF, 0, 20, 2, 1);
        Long savedStaffId = weaponService.save(savedPlayerId, staff);
        Weapon foundStaff = weaponService.findById(savedStaffId);

        Assertions.assertThat(foundStaff.getId()).isEqualTo(1L);
    }
}