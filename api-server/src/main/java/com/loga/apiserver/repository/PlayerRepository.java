package com.loga.apiserver.repository;

import com.loga.reinforcementserver.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    @Query("select p from Player p join fetch p.inventory where p.id = :id")
    Player findWithInventory(@Param("id") Long id);
    @Query("select distinct p from Player p join fetch p.inventory i left join fetch i.inventoryItems where p.id = :id")
    Player findWithInventoryAndInventoryItems(@Param("id") Long id);
    @Query("select distinct p from Player p join fetch p.inventory i left join fetch i.inventoryWeapons where p.id = :id")
    Player findWithInventoryAndInventoryWeapons(@Param("id") Long id);
}
