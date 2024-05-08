package com.loga.apiserver.service.weapon;

import com.loga.apiserver.domain.*;
import com.loga.apiserver.exception.MaxWeaponLevelExceededException;
import com.loga.apiserver.exception.NoHaveGoldException;
import com.loga.apiserver.exception.NoSuchWeaponException;
import com.loga.apiserver.exception.NotEnoughGoldException;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class WeaponReinforcementServiceImpl implements WeaponReinforcementService {
    private static final int AP_INCREASE_AMOUNT = 2;
    private static final int CONSUMPTION_GOLD = 5;
    private static final int MAXIMUM_WEAPON_LEVEL = 10;
    private static final int LEVEL_INCREASE_AMOUNT = 1;
    private final PlayerService playerService;
    @Autowired
    public WeaponReinforcementServiceImpl(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    @Transactional
    public Weapon reinforce(Long playerId, Long weaponId) {
        Player foundPlayer = playerService.findById(playerId);
        List<InventoryWeapon> inventoryWeapons = foundPlayer.getInventory().getInventoryWeapons();
        Weapon weapon = inventoryWeapons.stream().map(InventoryWeapon::getWeapon).filter(w -> w.getId().equals(weaponId))
                .findAny().orElseThrow(() -> new NoSuchWeaponException("무기를 찾을 수 없습니다."));
        if(weapon.getLevel() >= MAXIMUM_WEAPON_LEVEL) {
            throw new MaxWeaponLevelExceededException("무기가 최대 레벨 입니다.");
        }
        List<InventoryItem> inventoryItems = foundPlayer.getInventory().getInventoryItems();
        InventoryItem goldItem = inventoryItems.stream().filter(i -> i.getItem().getItemType().equals(ItemType.GOLD))
                .findAny().orElseThrow(() -> new NoHaveGoldException("골드가 존재하지 않습니다."));
        if(goldItem.getQuantity() >= CONSUMPTION_GOLD) {
            if(weapon.getAttackType().equals(AttackType.PHYSICAL)) {
                weapon.increasePhysicalAp(AP_INCREASE_AMOUNT);
                weapon.increaseLevel(LEVEL_INCREASE_AMOUNT);
                goldItem.decreaseQuantity(goldItem.getQuantity() - CONSUMPTION_GOLD);
            }
            else if(weapon.getAttackType().equals(AttackType.MAGICAL)) {
                weapon.increaseMagicalAp(AP_INCREASE_AMOUNT);
                weapon.increaseLevel(LEVEL_INCREASE_AMOUNT);
                goldItem.decreaseQuantity(goldItem.getQuantity() - CONSUMPTION_GOLD);
            }
        }
        else {
            throw new NotEnoughGoldException("골드가 부족합니다.");
        }
        return weapon;
    }
}
