package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.WeaponReinforceResponseDto;
import com.loga.apiserver.controller.dto.WeaponRequestDto;
import com.loga.apiserver.service.weapon.WeaponReinforcementService;
import com.loga.apiserver.service.weapon.WeaponService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "WeaponController", description = "무기 저장 및 강화 기능을 제공하는 컨트롤러")
public class WeaponController {
    private final WeaponService weaponService;
    private final WeaponReinforcementService reinforcementService;

    @Autowired
    public WeaponController(WeaponService weaponService, WeaponReinforcementService reinforcementService) {
        this.weaponService = weaponService;
        this.reinforcementService = reinforcementService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "save weapon"
                            , content = @Content(schema = @Schema(description = "weaponId", example = "1"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PostMapping("/players/{playerId}/weapons")
    public Long save(@PathVariable("playerId") Long playerId, @Valid @RequestBody WeaponRequestDto weaponRequestDto) {
        return weaponService.save(playerId, weaponRequestDto.toEntity());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "reinforce weapon"
                    , content = @Content(schema = @Schema(implementation = WeaponReinforceResponseDto.class))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                    , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/weapons/{weaponId}")
    public WeaponReinforceResponseDto reinforce(@PathVariable("playerId") Long playerId, @PathVariable("weaponId") Long weaponId) {
        return reinforcementService.reinforce(playerId, weaponId);
    }
}
