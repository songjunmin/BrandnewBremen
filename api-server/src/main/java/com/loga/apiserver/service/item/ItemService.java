package com.loga.apiserver.service.item;

import com.loga.apiserver.domain.Item;

public interface ItemService {
    Long save(Long playerId, Item item);
    void update(Long playerId, Item item);
    Item findById(Long id);
}