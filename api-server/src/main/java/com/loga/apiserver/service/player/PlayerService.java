package com.loga.apiserver.service.player;

import com.loga.apiserver.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PlayerService {
    Long save(Player player);
    Player findById(Long id);
    Player findWithInventory(Long id);
    Player findWithInventoryAndInventoryItemsAndItem(Long id);
    Player findWithInventoryAndInventoryWeaponsAndWeapon(Long id);
    Player findWithPlayerSkillsAndSKill(Long id);
}
