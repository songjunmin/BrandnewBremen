package com.loga.apiserver.service.weapon;

import com.loga.apiserver.domain.InventoryWeapon;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.domain.Weapon;
import com.loga.apiserver.exception.NoSuchWeaponException;
import com.loga.apiserver.repository.InventoryWeaponRepository;
import com.loga.apiserver.repository.WeaponRepository;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeaponServiceImpl implements WeaponService {
    private final PlayerService playerService;
    private final WeaponRepository weaponRepository;
    private final InventoryWeaponRepository inventoryWeaponRepository;

    @Autowired
    public WeaponServiceImpl(PlayerService playerService, WeaponRepository weaponRepository, InventoryWeaponRepository inventoryWeaponRepository) {
        this.playerService = playerService;
        this.weaponRepository = weaponRepository;
        this.inventoryWeaponRepository = inventoryWeaponRepository;
    }

    @Override
    @Transactional
    public Long save(Long playerId, Weapon weapon) {
        // Player foundPlayerWithInventory = playerService.findWithInventory(id);
        Player foundPlayer = playerService.findById(playerId);
        weaponRepository.save(weapon);
        InventoryWeapon inventoryWeapon = new InventoryWeapon();
        inventoryWeapon.setWeapon(weapon);
        foundPlayer.getInventory().addInventoryWeapon(inventoryWeapon);
        inventoryWeaponRepository.save(inventoryWeapon);
        return weapon.getId();
    }

    @Override
    @Transactional
    public Weapon findById(Long id) {
        return weaponRepository.findById(id).orElseThrow(() -> new NoSuchWeaponException("무기를 찾을 수 없습니다"));
    }

    @Override
    public Weapon findWithSkill(Long id) {
        return weaponRepository.findWithSkill(id);
    }
}
