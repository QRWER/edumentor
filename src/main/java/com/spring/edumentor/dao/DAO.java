package com.spring.edumentor.dao;

import java.util.List;

public interface DAO<T> {
    public List<T> getAll();
    public T getById(int id);
    public T save(T obj);
    public void deleteById(int id);
}
