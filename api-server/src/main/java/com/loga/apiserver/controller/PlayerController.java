package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.PlayerRequestDto;
import com.loga.apiserver.service.player.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    private final PlayerService playerService;
    private final PlayerHpUpgradeService hpUpgradeService;
    private final PlayerMpUpgradeService mpUpgradeService;
    private final PlayerStaminaUpgradeService staminaUpgradeService;
    private final PlayerPhysicalApUpgradeService physicalApUpgradeService;
    private final PlayerMagicalApUpgradeService magicalApUpgradeService;

    @Autowired
    public PlayerController(PlayerService playerService, PlayerHpUpgradeService hpUpgradeService, PlayerMpUpgradeService mpUpgradeService, PlayerStaminaUpgradeService staminaUpgradeService, PlayerPhysicalApUpgradeService physicalApUpgradeService, PlayerMagicalApUpgradeService magicalApUpgradeService) {
        this.playerService = playerService;
        this.hpUpgradeService = hpUpgradeService;
        this.mpUpgradeService = mpUpgradeService;
        this.staminaUpgradeService = staminaUpgradeService;
        this.physicalApUpgradeService = physicalApUpgradeService;
        this.magicalApUpgradeService = magicalApUpgradeService;
    }

    @PostMapping("/players")
    public Long save(@RequestBody PlayerRequestDto playerRequestDto) {
        return playerService.save(playerRequestDto.toEntity());
    }

    @PatchMapping("/players/{playerId}/stats/hp")
    public int hpUpgrade(@PathVariable("playerId") Long playerId) {
        return hpUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/mp")
    public int mpUpgrade(@PathVariable("playerId") Long playerId) {
        return mpUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/stamina")
    public int staminaUpgrade(@PathVariable("playerId") Long playerId) {
        return staminaUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/physicalAp")
    public int physicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return physicalApUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/magicalAp")
    public int magicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return magicalApUpgradeService.statUpgrade(playerId);
    }
}
