package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PlayerSkill {
    @Id @GeneratedValue
    @Column(name = "player_skill_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_id")
    private Player player;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_id")
    private Skill skill;

    public PlayerSkill(Player player, Skill skill) {
        this.player = player;
        this.skill = skill;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
    public void setSkill(Skill skill) { this. skill = skill; }
}
