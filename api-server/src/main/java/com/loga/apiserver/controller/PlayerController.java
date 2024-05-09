package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.PlayerRequestDto;
import com.loga.apiserver.service.player.*;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "PlayerController", description = "플레이어 저장 및 업그레이드 기능을 제공하는 컨트롤러")
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

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "save player"
                    , content = @Content(schema = @Schema(description = "playerId", example = "1"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                    , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PostMapping("/players")
    public Long save(@Valid @RequestBody PlayerRequestDto playerRequestDto) {
        return playerService.save(playerRequestDto.toEntity());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "hp upgrade"
                            , content = @Content(schema = @Schema(description = "hp", example = "120"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/stats/hp")
    public int hpUpgrade(@PathVariable("playerId") Long playerId) {
        return hpUpgradeService.statUpgrade(playerId);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "mp upgrade"
                            , content = @Content(schema = @Schema(description = "mp", example = "60"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/stats/mp")
    public int mpUpgrade(@PathVariable("playerId") Long playerId) {
        return mpUpgradeService.statUpgrade(playerId);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "stamina upgrade"
                            , content = @Content(schema = @Schema(description = "stamina", example = "60"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/stats/stamina")
    public int staminaUpgrade(@PathVariable("playerId") Long playerId) {
        return staminaUpgradeService.statUpgrade(playerId);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "physicalAp upgrade"
                            , content = @Content(schema = @Schema(description = "physicalAp", example = "11"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/stats/physicalAp")
    public int physicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return physicalApUpgradeService.statUpgrade(playerId);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "magicalAp upgrade"
                            , content = @Content(schema = @Schema(description = "magicalAp", example = "11"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/stats/magicalAp")
    public int magicalApUpgrade(@PathVariable("playerId") Long playerId) {
        return magicalApUpgradeService.statUpgrade(playerId);
    }
}
