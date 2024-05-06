package com.loga.apiserver.repository;

import com.loga.apiserver.domain.Skill;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillRepository implements CrudRepository<Skill, Long> {
    @PersistenceContext
    public EntityManager em;
    @Override
    public void save(Skill entity) {
        em.persist(entity);
    }
    @Override
    public Skill findById(Long id) {
        return em.find(Skill.class ,id);
    }
    public List<Skill> findAll() {
        return em.createQuery("select s from Skill s", Skill.class).getResultList();
    }
}
