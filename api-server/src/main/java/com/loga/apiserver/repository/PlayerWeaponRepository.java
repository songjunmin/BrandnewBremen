package com.loga.apiserver.repository;

import com.loga.apiserver.domain.PlayerWeapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerWeaponRepository extends JpaRepository<PlayerWeapon, Long> {
}
