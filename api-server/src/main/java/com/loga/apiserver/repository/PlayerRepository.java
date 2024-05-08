package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("select p from Player p join fetch p.inventory where p.id = :id")
    Player findWithInventory(@Param("id") Long id);
    @Query("select distinct p from Player p join fetch p.inventory i left join fetch i.inventoryItems ii left join fetch ii.item where p.id = :id")
    Player findWithInventoryAndInventoryItemsAndItem(@Param("id") Long id);
    @Query("select distinct p from Player p join fetch p.inventory i left join fetch i.inventoryWeapons iw left join fetch iw.weapon where p.id = :id")
    Player findWithInventoryAndInventoryWeaponsAndWeapon(@Param("id") Long id);
    @Query("select distinct p from Player p left join fetch p.playerSkills ps left join fetch ps.skill where p.id = :id")
    Player findWithPlayerSkillsAndSKill(@Param("id") Long id);
}
