package com.loga.apiserver.service.item;

import com.loga.apiserver.domain.InventoryItem;
import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.exception.NoSuchItemException;
import com.loga.apiserver.repository.InventoryItemRepository;
import com.loga.apiserver.repository.ItemRepository;
import com.loga.apiserver.service.player.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemServiceImpl implements ItemService {
    private final PlayerService playerService;
    private final ItemRepository itemRepository;
    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public ItemServiceImpl(PlayerService playerService, ItemRepository itemRepository, InventoryItemRepository inventoryItemRepository) {
        this.playerService = playerService;
        this.itemRepository = itemRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    @Override
    @Transactional
    public Long save(Long playerId, Item item) {
        Player foundPlayer = playerService.findById(playerId);
        itemRepository.save(item);
        InventoryItem inventoryItem = new InventoryItem(item, item.getQuantity());
        foundPlayer.getInventory().addInventoryItem(inventoryItem);
        inventoryItemRepository.save(inventoryItem);
        return item.getId();
    }

    @Override
    @Transactional
    public void update(Long playerId, Long itemId, Item item) {
        Player foundPlayer = playerService.findById(playerId);
        InventoryItem inventoryItem = foundPlayer.getInventory().getInventoryItems().stream()
                .filter(ii -> ii.getItem().getId().equals(itemId))
                .findAny().orElseThrow(() -> new NoSuchItemException("아이템을 찾을 수 없습니다."));
        inventoryItem.increaseQuantity(item.getQuantity());
    }

    @Override
    @Transactional
    public Item findById(Long id) {
        return itemRepository.findById(id).orElseThrow(() -> new NoSuchItemException("아이템을 찾을 수 없습니다"));
    }
}
