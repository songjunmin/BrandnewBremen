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
class PlayerMagicalApUpgradeServiceTest {
    @Autowired
    PlayerService playerService;
    @Autowired
    ItemService itemService;
    @Autowired
    PlayerMagicalApUpgradeService magicalApUpgradeService;

    @Test
    @DisplayName("골드 O")
    void physicalApUpgradeSuccess() {
        // 아이템 저장
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item(ItemType.GOLD, 10);
        itemService.save(savedPlayerId, item);

        // 강화
        Player updatedPlayer = magicalApUpgradeService.statUpgrade(savedPlayerId);
        Assertions.assertThat(updatedPlayer.getMagicalAp()).isEqualTo(11);
    }
    @Test
    @DisplayName("골드 부족")
    void physicalApUpgradeFailure() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item(ItemType.GOLD, 1);
        itemService.save(savedPlayerId, item);

        Assertions.assertThatThrownBy(() -> magicalApUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(NotEnoughGoldException.class);
    }
    @Test
    @DisplayName("골드 X")
    void physicalApUpgradeX() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item(ItemType.HP, 1);
        itemService.save(savedPlayerId, item);

        Assertions.assertThatThrownBy(() -> magicalApUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(NoHaveGoldException.class);
    }
    @Test
    @DisplayName("스탯 MAX")
    void limit() {
        Player player = new Player(100, 50, 50, 10, 15);
        Long savedPlayerId = playerService.save(player);
        Item item = new Item(ItemType.GOLD, 10);
        itemService.save(savedPlayerId, item);

        Assertions.assertThatThrownBy(() -> magicalApUpgradeService.statUpgrade(savedPlayerId))
                .isInstanceOf(MaxStatAmountExceededException.class);
    }
}