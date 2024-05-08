package com.loga.apiserver.service.weapon;

import com.loga.apiserver.domain.Weapon;

public interface WeaponService {
    Long save(Long playerId, Weapon weapon);
    Weapon findById(Long id);
    Weapon findWithSkill(Long id);
}
