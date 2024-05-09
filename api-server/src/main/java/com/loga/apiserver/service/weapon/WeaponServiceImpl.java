package com.loga.apiserver.service.weapon;

import com.loga.apiserver.domain.InventoryWeapon;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.domain.PlayerWeapon;
import com.loga.apiserver.domain.Weapon;
import com.loga.apiserver.exception.NoSuchWeaponException;
import com.loga.apiserver.exception.WeaponAlreadySavedException;
import com.loga.apiserver.repository.InventoryWeaponRepository;
import com.loga.apiserver.repository.PlayerWeaponRepository;
import com.loga.apiserver.repository.WeaponRepository;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class WeaponServiceImpl implements WeaponService {
    private final PlayerService playerService;
    private final WeaponRepository weaponRepository;
    private final PlayerWeaponRepository playerWeaponRepository;
    private final InventoryWeaponRepository inventoryWeaponRepository;

    @Autowired
    public WeaponServiceImpl(PlayerService playerService, WeaponRepository weaponRepository, PlayerWeaponRepository playerWeaponRepository, InventoryWeaponRepository inventoryWeaponRepository) {
        this.playerService = playerService;
        this.weaponRepository = weaponRepository;
        this.playerWeaponRepository = playerWeaponRepository;
        this.inventoryWeaponRepository = inventoryWeaponRepository;
    }

    @Override
    @Transactional
    public Long save(Long playerId, Weapon weapon) {
        Player foundPlayer = playerService.findById(playerId);
        boolean isPresent = foundPlayer.getPlayerWeapons().stream()
                .anyMatch(pw -> pw.getWeapon().getWeaponName().equals(weapon.getWeaponName()));
        if(isPresent) {
            throw new WeaponAlreadySavedException("이미 저장된 무기 입니다.");
        }
        weaponRepository.save(weapon);
        InventoryWeapon inventoryWeapon = new InventoryWeapon();
        inventoryWeapon.setWeapon(weapon);
        foundPlayer.getInventory().addInventoryWeapon(inventoryWeapon);
        inventoryWeaponRepository.save(inventoryWeapon);
        PlayerWeapon playerWeapon = new PlayerWeapon();
        foundPlayer.addPlayerWeapon(playerWeapon);
        playerWeapon.setWeapon(weapon);
        playerWeaponRepository.save(playerWeapon);
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
