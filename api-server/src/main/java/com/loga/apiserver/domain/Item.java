package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Item extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    @Column(name = "item_name")
    private String itemName;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemType itemType;

    @Builder
    public Item(String itemName, ItemType itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }
}
