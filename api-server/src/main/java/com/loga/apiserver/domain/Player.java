package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

@Entity
@Getter
@NoArgsConstructor
public class Player extends BaseEntity {
    @Id @GeneratedValue
    @Column(name = "player_id")
    private Long id;
    private int hp;
    private int mp;
    private int stamina;
    @Column(name = "physical_ap")
    private int physicalAp;
    @Column(name = "magical_ap")
    private int magicalAp;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerItem> playerItems = new ArrayList<>();
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerWeapon> playerWeapons = new ArrayList<>();
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerSkill> playerSkills = new ArrayList<>();

    @Builder
    public Player(int hp, int mp, int stamina, int physicalAp, int magicalAp) {
        this.hp = hp;
        this.mp = mp;
        this.stamina = stamina;
        this.physicalAp = physicalAp;
        this.magicalAp = magicalAp;
    }
    public void addInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void addPlayerItem(PlayerItem playerItem) {
        playerItems.add(playerItem);
        playerItem.setPlayer(this);
    }

    public void addPlayerWeapon(PlayerWeapon playerWeapon) {
        playerWeapons.add(playerWeapon);
        playerWeapon.setPlayer(this);
    }

    public void addPlayerSkill(PlayerSkill playerSkill) {
        playerSkills.add(playerSkill);
        playerSkill.setPlayer(this);
    }

    public void increaseStats(Consumer<Integer> integerConsumer, int value) {
        integerConsumer.accept(value);
    }
    public void increaseHp(int hp) {
        this.hp += hp;
    }
    public void increaseMp(int mp) {
        this.mp += mp;
    }
    public void increaseStamina(int stamina) {
        this.stamina += stamina;
    }
    public void increasePhysicalAp(int ap) {
        physicalAp += ap;
    }
    public void increaseMagicalAp(int ap) {
        magicalAp += ap;
    }
}
