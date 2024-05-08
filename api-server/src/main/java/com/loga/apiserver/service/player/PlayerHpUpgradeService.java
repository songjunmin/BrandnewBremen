package com.loga.apiserver.service.player;


import com.loga.apiserver.domain.Player;
import com.loga.apiserver.exception.MaxStatAmountExceededException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PlayerHpUpgradeService extends PlayerStatUpgradeService {
    private static final int HP_INCREASE_AMOUNT = 20;
    private static final int CONSUMPTION_GOLD = 5;
    private static final int MAXIMUM_STAT_AMOUNT = 200;
    private final PlayerService playerService;
    @Autowired
    public PlayerHpUpgradeService(PlayerService playerService) {
        super(playerService);
        this.playerService = playerService;
    }
    @Transactional
    public int statUpgrade(Long id) {
        Player foundPlayer = playerService.findById(id);
        if(foundPlayer.getHp() >= MAXIMUM_STAT_AMOUNT) {
            throw new MaxStatAmountExceededException("강화로 올릴 수 있는 최대 체력에 도달했습니다.");
        }
        return super.logic(id, HP_INCREASE_AMOUNT, CONSUMPTION_GOLD, foundPlayer::increaseHp).getHp();
    }
}
