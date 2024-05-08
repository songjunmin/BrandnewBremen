package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    /*@Query("select distinct i from Inventory i join fetch i.inventoryItems where i.id = :id")
    Inventory findWithInventoryItems(@Param("id") Long id);*/
    /*@Query("select distinct i from Inventory i join fetch i.inventoryWeapons where i.id = :id")
    Inventory findWithInventoryWeapons(@Param("id") Long id);*/
}
