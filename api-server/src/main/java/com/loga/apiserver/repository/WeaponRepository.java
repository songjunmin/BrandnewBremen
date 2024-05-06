package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Weapon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class WeaponRepository implements CrudRepository<Weapon, Long> {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Weapon entity) {
        em.persist(entity);
    }
    @Override
    public Weapon findById(Long id) {
        return em.find(Weapon.class, id);
    }
}
