package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.ItemType;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class ItemRequestDto {
    private ItemType itemType;
    private int quantity;

    public Item toEntity() {
        return Item.builder().itemType(itemType).quantity(quantity).build();
    }
}
