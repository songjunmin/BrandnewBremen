package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.WeaponReinforceResponseDto;
import com.loga.apiserver.controller.dto.WeaponRequestDto;
import com.loga.apiserver.service.weapon.WeaponReinforcementService;
import com.loga.apiserver.service.weapon.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class WeaponController {
    private final WeaponService weaponService;
    private final WeaponReinforcementService reinforcementService;

    @Autowired
    public WeaponController(WeaponService weaponService, WeaponReinforcementService reinforcementService) {
        this.weaponService = weaponService;
        this.reinforcementService = reinforcementService;
    }

    @PostMapping("/players/{playerId}/weapons")
    public Long save(@PathVariable("playerId") Long playerId, @RequestBody WeaponRequestDto weaponRequestDto) {
        return weaponService.save(playerId, weaponRequestDto.toEntity());
    }
    @PatchMapping("/players/{playerId}/weapons/{weaponId}")
    public WeaponReinforceResponseDto reinforce(@PathVariable("playerId") Long playerId, @PathVariable("weaponId") Long weaponId) {
        return reinforcementService.reinforce(playerId, weaponId);
    }
}
