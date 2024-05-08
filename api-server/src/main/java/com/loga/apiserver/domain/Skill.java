package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Skill extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "skill_id")
    private Long id;
    @Column(name = "range")
    private int range;
    @Column(name = "cool_time")
    private int coolTime;
    @Column(name = "mp_consumption")
    private int mpConsumption;
    @Column(name = "skill_coefficient")
    private double skillCoefficient;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;

    public Skill(int range, int coolTime, int mpConsumption, double skillCoefficient) {
        this.range = range;
        this.coolTime = coolTime;
        this.mpConsumption = mpConsumption;
        this.skillCoefficient = skillCoefficient;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void increaseSkillCoefficient(int skillCoefficient) {
        this.skillCoefficient += skillCoefficient;
    }
}
