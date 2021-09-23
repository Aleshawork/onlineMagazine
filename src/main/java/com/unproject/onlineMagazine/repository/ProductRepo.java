package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements CrudOperations<Product> {
    //todo: реализация

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
