package com.loga.apiserver.repository;

import com.loga.reinforcementserver.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
