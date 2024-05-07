package com.loga.apiserver.repository;

import com.loga.reinforcementserver.domain.InventoryWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryWeaponRepository extends JpaRepository<InventoryWeapon, Long> {
}
