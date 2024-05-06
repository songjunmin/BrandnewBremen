package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository implements CrudRepository<Item, Long> {
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Item entity) {
        em.persist(entity);
    }
    @Override
    public Item findById(Long id) {
        return em.find(Item.class, id);
    }
    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

}
