package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ItemSaveRequestDto {
    @NotEmpty
    @Schema(description = "item name", example = "gold")
    private String itemName;
    @ValidEnum(enumClass = ItemType.class)
    @Schema(description = "item type", example = "GOLD")
    private ItemType itemType;
    @NotNull
    @Schema(description = "item quantity", example = "1")
    private int quantity;

    public Item toEntity() {
        return Item.builder().itemName(itemName).itemType(itemType).build();
    }
}
