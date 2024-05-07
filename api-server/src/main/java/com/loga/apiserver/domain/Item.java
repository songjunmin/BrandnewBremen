package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemType itemType;
    private int quantity;

    public Item(ItemType itemType, int quantity) {
        this.itemType = itemType;
        this.quantity = quantity;
    }

}
