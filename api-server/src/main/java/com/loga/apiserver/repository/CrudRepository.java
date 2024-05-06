package com.loga.apiserver.repository;

public interface CrudRepository<T, ID> {
    void save(T entity);
    T findById(ID id);
}
