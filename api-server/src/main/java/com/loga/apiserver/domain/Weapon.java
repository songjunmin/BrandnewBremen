package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Weapon extends BaseEntity {
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

    @Builder
    public Weapon(AttackType attackType, WeaponType weaponType, int physicalAp, int magicalAp, double attackCoefficient, int level) {
        this.attackType = attackType;
        this.weaponType = weaponType;
        this.physicalAp = physicalAp;
        this.magicalAp = magicalAp;
        this.attackCoefficient = attackCoefficient;
        this.level = level;
    }
    public void addSkill(Skill skill) {
        skills.add(skill);
        skill.setWeapon(this);
    }
    public void increasePhysicalAp(int ap) {
        physicalAp += ap;
    }
    public void increaseMagicalAp(int ap) {
        magicalAp += ap;
    }
    public void increaseLevel(int level) {
        this.level += level;
    }
}
