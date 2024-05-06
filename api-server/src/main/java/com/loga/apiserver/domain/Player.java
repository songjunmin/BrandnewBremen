package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Player {
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
    @Column(name = "create_date")
    private LocalDateTime createDate;
    @Column(name = "last_update_date")
    private LocalDateTime lastUpdateDate;
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerItem> playerItems = new ArrayList<>();
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY)
    private List<PlayerSkill> playerSkills = new ArrayList<>();
}
