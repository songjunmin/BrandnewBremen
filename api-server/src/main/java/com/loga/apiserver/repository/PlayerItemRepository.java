package com.loga.apiserver.repository;

import com.loga.apiserver.domain.PlayerItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerItemRepository extends JpaRepository<PlayerItem, Long> {
}
