package com.loga.apiserver.service.player;

import com.loga.apiserver.domain.InventoryItem;
import com.loga.apiserver.domain.ItemType;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.exception.NoHaveGoldException;
import com.loga.apiserver.exception.NotEnoughGoldException;

import java.util.List;
import java.util.function.Consumer;

public abstract class PlayerStatUpgradeService {
    private final PlayerService playerService;

    public PlayerStatUpgradeService(PlayerService playerService) {
        this.playerService = playerService;
    }
    Player logic(Long id, int increaseAmount, int consumptionGold, Consumer<Integer> increaseConsumer) {
        Player foundPlayer = playerService.findById(id);
        List<InventoryItem> inventoryItems = foundPlayer.getInventory().getInventoryItems();
        System.out.println(inventoryItems.size());
        InventoryItem goldItem = inventoryItems.stream().filter(i -> i.getItem().getItemType().equals(ItemType.GOLD))
                .findAny().orElseThrow(() -> new NoHaveGoldException("골드가 존재하지 않습니다."));
        if(goldItem.getQuantity() >= consumptionGold) {
            goldItem.decreaseQuantity(goldItem.getQuantity() - consumptionGold);
            foundPlayer.increaseStats(increaseConsumer, increaseAmount);
        }
        else {
            throw new NotEnoughGoldException("공격력을 업그레이드 하기 위한 골드가 부족합니다.");
        }
        return foundPlayer;
    }
}
