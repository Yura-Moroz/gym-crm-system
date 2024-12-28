package com.yuramoroz.spring_crm_system.repository;

import java.util.List;

public interface BaseDAO<T> {

    public T getById(Long id);

    public List<T> getAllItems();

    public void create(T entity);

    public void update(T entity);

    public void delete(T entity);
}
