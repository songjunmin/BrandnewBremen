package com.loga.apiserver.service.weapon;

import com.loga.apiserver.domain.Weapon;

public interface WeaponReinforcementService {
    Weapon reinforce(Long playerId, Long weaponId);
}
