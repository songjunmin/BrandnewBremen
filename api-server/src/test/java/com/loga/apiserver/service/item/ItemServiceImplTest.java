package com.loga.apiserver.service.item;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.ItemType;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.service.player.PlayerService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = ApiServerApplication.class)
@ExtendWith(SpringExtension.class)
@Transactional
class ItemServiceImplTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    ItemService itemService;
    @Test
    void itemSave() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        Long savedItemId = itemService.save(savedPlayerId, 10, item);
        Item foundItem = itemService.findById(savedItemId);

        Assertions.assertThat(foundItem.getId()).isEqualTo(savedItemId);
    }
}