package com.loga.apiserver.controller.dto;

import com.loga.apiserver.service.item.ItemService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "ItemController", description = "아이템 저장 및 업데이트 기능을 제공하는 컨트롤러")
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "save item"
                    , content = @Content(schema = @Schema(description = "itemId", example = "1"))),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                    , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PostMapping("/players/{playerId}/items")
    public Long save(@PathVariable("playerId") Long playerId, @Valid @RequestBody ItemSaveRequestDto saveRequestDto) {
        return itemService.save(playerId, saveRequestDto.getQuantity(), saveRequestDto.toEntity());
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "item update"),
                    @ApiResponse(responseCode = "400", description = "bad request parameter"
                            , content = @Content(schema = @Schema(example = "bad request parameter")))
            }
    )
    @PatchMapping("/players/{playerId}/items/{itemId}")
    public void update(@PathVariable("playerId") Long playerId, @PathVariable("itemId") Long itemId, @Valid @RequestBody ItemUpdateRequestDto updateRequestDto) {
        itemService.update(playerId, itemId, updateRequestDto.getQuantity());
    }
}
