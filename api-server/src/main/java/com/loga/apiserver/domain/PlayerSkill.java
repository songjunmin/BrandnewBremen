package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
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
}
