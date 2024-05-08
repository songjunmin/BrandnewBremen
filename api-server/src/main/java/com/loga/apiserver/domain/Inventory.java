package com.loga.apiserver.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Inventory {
    @Id @GeneratedValue
    @Column(name = "inventory_id")
    private Long id;
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY)
    private List<InventoryItem> inventoryItems = new ArrayList<>();
    @OneToMany(mappedBy = "inventory", fetch = FetchType.LAZY)
    private List<InventoryWeapon> inventoryWeapons = new ArrayList<>();

    public void addInventoryItem(InventoryItem inventoryItem) {
        inventoryItems.add(inventoryItem);
        inventoryItem.setInventory(this);
    }
    public void addInventoryWeapon(InventoryWeapon inventoryWeapon) {
        inventoryWeapons.add(inventoryWeapon);
        inventoryWeapon.setInventory(this);
    }
}
