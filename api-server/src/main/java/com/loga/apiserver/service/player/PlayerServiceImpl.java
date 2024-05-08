package com.loga.apiserver.service.player;

import com.loga.apiserver.domain.Inventory;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.exception.NoSuchPlayerException;
import com.loga.apiserver.repository.InventoryRepository;
import com.loga.apiserver.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlayerServiceImpl implements PlayerService {
    private final PlayerRepository playerRepository;
    private final InventoryRepository inventoryRepository;

    @Autowired
    public PlayerServiceImpl(PlayerRepository playerRepository, InventoryRepository inventoryRepository) {
        this.playerRepository = playerRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    @Transactional
    public Long save(Player player) {
        Inventory inventory = new Inventory();
        inventoryRepository.save(inventory);
        player.addInventory(inventory);
        playerRepository.save(player);
        return player.getId();
    }

    @Override
    @Transactional
    public Player findById(Long id) {
        return playerRepository.findById(id).orElseThrow(() -> new NoSuchPlayerException("플레이어를 찾을 수 없습니다"));
    }

    @Override
    @Transactional
    public Player findWithInventory(Long id) {
        return playerRepository.findWithInventory(id);
    }

    @Override
    @Transactional
    public Player findWithInventoryAndInventoryItemsAndItem(Long id) {
        return playerRepository.findWithInventoryAndInventoryItemsAndItem(id);
    }

    @Override
    @Transactional
    public Player findWithInventoryAndInventoryWeaponsAndWeapon(Long id) {
        return playerRepository.findWithInventoryAndInventoryWeaponsAndWeapon(id);
    }

    @Override
    @Transactional
    public Player findWithPlayerSkillsAndSKill(Long id) {
        return playerRepository.findWithPlayerSkillsAndSKill(id);
    }
}
