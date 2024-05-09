package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PlayerWeapon {
    @Id @GeneratedValue
    @Column(name = "player_weapon_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
}
