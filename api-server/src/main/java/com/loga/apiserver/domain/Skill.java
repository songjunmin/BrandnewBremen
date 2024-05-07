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
    @Column(name = "skill_coefficient")
    private double skillCoefficient;
    @Column(name = "cool_time")
    private int coolTime;
    @Column(name = "mp_consumption")
    private int mpConsumption;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "weapon_id")
    private Weapon weapon;
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    List<PlayerSkill> playerSkills = new ArrayList<>();

    public Skill(double skillCoefficient, int coolTime, int mpConsumption) {
        this.skillCoefficient = skillCoefficient;
        this.coolTime = coolTime;
        this.mpConsumption = mpConsumption;
    }
    public void addPlayerSkill(PlayerSkill playerSkill) {
        playerSkills.add(playerSkill);
        playerSkill.setSkill(this);
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
