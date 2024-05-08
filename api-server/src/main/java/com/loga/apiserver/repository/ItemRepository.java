package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
