package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class PlayerItem {
    @Id @GeneratedValue
    @Column(name = "player_item_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private int quantity;
}
