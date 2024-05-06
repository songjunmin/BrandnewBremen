package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Weapon {
    @Id @GeneratedValue
    @Column(name = "weapon_id")
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "attack_type")
    private AttackType attackType;
    @Column(name = "weapon_type")
    private WeaponType weaponType;
    @Column(name = "physical_ap")
    private int physicalAp;
    @Column(name = "magical_ap")
    private int magicalAp;
    @Column(name = "attack_coefficient")
    private double attackCoefficient;
    private int level;
    @OneToMany(mappedBy = "weapon", fetch = FetchType.LAZY)
    private List<Skill> skills = new ArrayList<>();

    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.setWeapon(this);
    }
}
