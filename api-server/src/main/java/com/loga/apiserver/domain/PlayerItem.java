package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PlayerItem {
    @Id @GeneratedValue
    @Column(name = "player_item_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
}
