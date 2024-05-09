package com.loga.apiserver.service.item;

import com.loga.apiserver.domain.InventoryItem;
import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.domain.PlayerItem;
import com.loga.apiserver.exception.ItemAlreadySavedException;
import com.loga.apiserver.exception.NoSuchItemException;
import com.loga.apiserver.repository.InventoryItemRepository;
import com.loga.apiserver.repository.ItemRepository;
import com.loga.apiserver.repository.PlayerItemRepository;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final PlayerService playerService;
    private final ItemRepository itemRepository;
    private final PlayerItemRepository playerItemRepository;
    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public ItemServiceImpl(PlayerService playerService, ItemRepository itemRepository, PlayerItemRepository playerItemRepository, InventoryItemRepository inventoryItemRepository) {
        this.playerService = playerService;
        this.itemRepository = itemRepository;
        this.playerItemRepository = playerItemRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    @Transactional
    public Long save(Long playerId, int quantity, Item item) {
        Player foundPlayer = playerService.findById(playerId);
        boolean isPresent = foundPlayer.getPlayerItems().stream()
                .anyMatch(pi -> pi.getItem().getItemName().equals(item.getItemName()));
        if (isPresent) {
            throw new ItemAlreadySavedException("이미 저장된 아이템 입니다.");
        }
        itemRepository.save(item);
        InventoryItem inventoryItem = new InventoryItem(item, quantity);
        foundPlayer.getInventory().addInventoryItem(inventoryItem);
        inventoryItemRepository.save(inventoryItem);
        PlayerItem playerItem = new PlayerItem();
        foundPlayer.addPlayerItem(playerItem);
        playerItem.setItem(item);
        playerItemRepository.save(playerItem);
        return item.getId();
    }

    @Override
    @Transactional
    public void update(Long playerId, Long itemId, int quantity) {
        Player foundPlayer = playerService.findById(playerId);
        InventoryItem inventoryItem = foundPlayer.getInventory().getInventoryItems().stream()
                .filter(ii -> ii.getItem().getId().equals(itemId))
                .findAny().orElseThrow(() -> new NoSuchItemException("아이템을 찾을 수 없습니다."));
        inventoryItem.increaseQuantity(quantity);
    }

    @Override
    @Transactional
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchItemException("아이템을 찾을 수 없습니다"));
    }
}
