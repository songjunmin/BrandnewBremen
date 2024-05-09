package com.loga.apiserver.controller.dto;

import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.ItemType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ItemRequestDto {
    @NotEmpty
    @Schema(description = "item type", example = "GOLD")
    private ItemType itemType;
    @NotEmpty
    @Schema(description = "item quantity", example = "1")
    private int quantity;

    public Item toEntity() {
        return Item.builder().itemType(itemType).quantity(quantity).build();
    }
}
