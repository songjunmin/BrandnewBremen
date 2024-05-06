package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Skill {
    @Id @GeneratedValue
    @Column(name = "skill_id")
    private Long id;
    @Column(name = "skill_coefficient")
    private double skillCoefficient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
    @Column(name = "cool_time")
    private int coolTime;
    @Column(name = "mp_consumption")
    private int mpConsumption;

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
