package com.loga.apiserver.controller;

import com.loga.apiserver.domain.Player;
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
    Long save(@RequestBody Player player) {
        playerService.save(player);
        return player.getId();
    }

    @PatchMapping("/players/{playerId}/stats/hp")
    int hpUpgrade(@PathVariable("playerId") Long playerId) {
        return hpUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/mp")
    int mpUpgrade(@PathVariable("playerId") Long playerId) {
        return mpUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/stamina")
    int staminaUpgrade(@PathVariable("playerId") Long playerId) {
        return staminaUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/physicalAp")
    int physicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return physicalApUpgradeService.statUpgrade(playerId);
    }

    @PatchMapping("/players/{playerId}/stats/magicalAp")
    int magicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return magicalApUpgradeService.statUpgrade(playerId);
    }
}
