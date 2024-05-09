package com.loga.apiserver.service.item;

import com.loga.apiserver.domain.Item;

public interface ItemService {
    Long save(Long playerId, int quantity, Item item);
    void update(Long playerId, Long itemId, int quantity);
    Item findById(Long id);
}
