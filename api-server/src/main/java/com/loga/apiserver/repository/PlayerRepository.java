package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PlayerRepository implements CrudRepository<Player, Long> {
    @PersistenceContext
    private EntityManager em;
    @Override
    public void save(Player entity) {
        em.persist(entity);
    }
    @Override
    public Player findById(Long id) {
        return em.find(Player.class, id);
    }
}
