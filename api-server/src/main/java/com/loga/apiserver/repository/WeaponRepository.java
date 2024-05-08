package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
    @Query("select distinct w from Weapon w left join fetch w.skills where w.id = :id")
    Weapon findWithSkill(@Param("id") Long id);
}
