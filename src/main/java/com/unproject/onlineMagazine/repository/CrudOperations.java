package com.unproject.onlineMagazine.repository;

import java.util.List;

public interface CrudOperations<T> {
    public T getById(Long id);
    public void insert(T t);
    public void update(T t);
    public void deleteById(Long id);
    public List<T> getAll();

}
