package com.loga.apiserver.service.player;

import com.loga.apiserver.ApiServerApplication;
import com.loga.apiserver.domain.Player;
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
class PlayerServiceImplTest {
    @Autowired
    PlayerService playerService;
    @Test
    void playerSave() {
        Player player = new Player(100, 50, 50, 10, 10);
        Long savedId = playerService.save(player);
        Player foundPlayer = playerService.findById(savedId);
        Assertions.assertThat(savedId).isEqualTo(foundPlayer.getId());
    }
}