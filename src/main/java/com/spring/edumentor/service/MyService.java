package com.spring.edumentor.service;

import java.util.List;

public interface MyService<T> {
    public List<T> getAll();
    public T getById(int id);
    public T save(T obj);
    public void deleteById(int id);
}
