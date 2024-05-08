package com.loga.apiserver.controller;

import com.loga.apiserver.controller.dto.ItemRequestDto;
import com.loga.apiserver.service.item.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/players/{playerId}/items")
    public Long save(@PathVariable("playerId") Long playerId, @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.save(playerId, itemRequestDto.toEntity());
    }

    @PatchMapping("/players/{playerId}/items/{itemId}")
    public void update(@PathVariable("playerId") Long playerId, @PathVariable("itemId") Long itemId, @RequestBody ItemRequestDto itemRequestDto) {
        itemService.update(playerId, itemId, itemRequestDto.toEntity());
    }
}
