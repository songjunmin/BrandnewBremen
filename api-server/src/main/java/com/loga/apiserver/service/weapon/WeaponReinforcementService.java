package com.loga.apiserver.service.weapon;

import com.loga.apiserver.controller.dto.WeaponReinforceResponseDto;

public interface WeaponReinforcementService {
    WeaponReinforceResponseDto reinforce(Long playerId, Long weaponId);
}
