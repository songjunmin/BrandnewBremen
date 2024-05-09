package com.loga.apiserver.service.weapon;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.controller.dto.WeaponReinforceResponseDto;
import com.loga.apiserver.domain.*;
import com.loga.apiserver.exception.MaxWeaponLevelExceededException;
import com.loga.apiserver.exception.NoHaveGoldException;
import com.loga.apiserver.exception.NotEnoughGoldException;
import com.loga.apiserver.service.item.ItemService;
import com.loga.apiserver.service.player.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = ApiServerApplication.class)
@ExtendWith(SpringExtension.class)
@Transactional
class WeaponReinforcementServiceImplTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    ItemService itemService;
    @Autowired
    WeaponService weaponService;
    @Autowired
    WeaponReinforcementService reinforcementService;

    @Test
    @DisplayName("마력 무기 골드 O")
    void reinforceSuccess1() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 10, item);
        Weapon staff = new Weapon("staff", AttackType.MAGICAL, WeaponType.STAFF, 0, 20, 2, 1);
        Long savedStaffId = weaponService.save(savedPlayerId, staff);

        WeaponReinforceResponseDto reinforcedStaff = reinforcementService.reinforce(savedPlayerId, savedStaffId);

        Assertions.assertThat(reinforcedStaff.getLevel()).isEqualTo(2);
        Assertions.assertThat(reinforcedStaff.getAp()).isEqualTo(22);
    }
    @Test
    @DisplayName("공격력 무기 골드 O")
    void reinforceSuccess2() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 10, item);
        Weapon axe = new Weapon("axe", AttackType.PHYSICAL, WeaponType.AXE, 15, 0, 1.5, 1);
        Long savedAxeId = weaponService.save(savedPlayerId, axe);

        WeaponReinforceResponseDto reinforcedAxe = reinforcementService.reinforce(savedPlayerId, savedAxeId);

        Assertions.assertThat(reinforcedAxe.getLevel()).isEqualTo(2);
        Assertions.assertThat(reinforcedAxe.getAp()).isEqualTo(17);
    }
    @Test
    @DisplayName("골드 부족")
    void hpUpgradeFailure() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 1, item);
        Weapon staff = new Weapon("staff", AttackType.MAGICAL, WeaponType.STAFF, 0, 20, 2, 1);
        Long savedStaffId = weaponService.save(savedPlayerId, staff);

        Assertions.assertThatThrownBy(() -> reinforcementService.reinforce(savedPlayerId, savedStaffId))
                .isInstanceOf(NotEnoughGoldException.class);
    }
    @Test
    @DisplayName("골드 X")
    void hpUpgradeX() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.HP);
        itemService.save(savedPlayerId, 1, item);
        Weapon axe = new Weapon("axe", AttackType.PHYSICAL, WeaponType.AXE, 15, 0, 1.5, 1);
        Long savedAxeId = weaponService.save(savedPlayerId, axe);

        Assertions.assertThatThrownBy(() -> reinforcementService.reinforce(savedPlayerId, savedAxeId))
                .isInstanceOf(NoHaveGoldException.class);
    }
    @Test
    @DisplayName("레벨 MAX")
    void limit() {
        Player player = new Player(200, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 10, item);
        Weapon staff = new Weapon("staff", AttackType.MAGICAL, WeaponType.STAFF, 0, 20, 2, 10);
        Long savedStaffId = weaponService.save(savedPlayerId, staff);

        Assertions.assertThatThrownBy(() -> reinforcementService.reinforce(savedPlayerId, savedStaffId))
                .isInstanceOf(MaxWeaponLevelExceededException.class);
    }
}