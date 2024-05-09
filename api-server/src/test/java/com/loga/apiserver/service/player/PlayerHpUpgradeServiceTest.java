package com.loga.apiserver.service.player;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.domain.Item;
import com.loga.apiserver.domain.ItemType;
import com.loga.apiserver.domain.Player;
import com.loga.apiserver.exception.MaxStatAmountExceededException;
import com.loga.apiserver.exception.NoHaveGoldException;
import com.loga.apiserver.exception.NotEnoughGoldException;
import com.loga.apiserver.service.item.ItemService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = ApiServerApplication.class)
@ExtendWith(SpringExtension.class)
@Transactional
class PlayerHpUpgradeServiceTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    ItemService itemService;
    @Autowired
    PlayerHpUpgradeService hpUpgradeService;

    @Test
    @DisplayName("골드 O")
    void hpUpgradeSuccess() {
        // 아이템 저장
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 10, item);

        // 강화
        int updatedHp = hpUpgradeService.statUpgrade(savedPlayerId);
        Assertions.assertThat(updatedHp).isEqualTo(120);
    }
    @Test
    @DisplayName("골드 부족")
    void hpUpgradeFailure() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 1, item);

        Assertions.assertThatThrownBy(() -> hpUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(NotEnoughGoldException.class);
    }
    @Test
    @DisplayName("골드 X")
    void hpUpgradeX() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("hp", ItemType.HP);
        itemService.save(savedPlayerId, 1, item);

        Assertions.assertThatThrownBy(() -> hpUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(NoHaveGoldException.class);
    }
    @Test
    @DisplayName("스탯 MAX")
    void limit() {
        Player player = new Player(200, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item("gold", ItemType.GOLD);
        itemService.save(savedPlayerId, 10, item);

        Assertions.assertThatThrownBy(() -> hpUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(MaxStatAmountExceededException.class);
    }
}