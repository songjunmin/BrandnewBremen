package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Item {
    @Id @GeneratedValue
    @Column(name = "item_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "item_type")
    private ItemType itemType;
}
