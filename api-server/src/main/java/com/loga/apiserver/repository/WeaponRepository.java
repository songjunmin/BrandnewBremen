package com.loga.apiserver.repository;

import com.loga.reinforcementserver.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
