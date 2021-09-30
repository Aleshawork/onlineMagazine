package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.repository.mapper.OrdersMapper;
import com.unproject.onlineMagazine.repository.mapper.ProductMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepo implements CrudOperations<Product> {
    private final JdbcOperations jdbc;

    public ProductRepo(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Product getById(Long id) {
        return null;
    }

    @Override
    public void insert(Product product) {
         jdbc.update(
                "insert into product(product_type,description,weight) values(?,?,?)",
                product.getProduct_type(),
                product.getDescription(),
                product.getWeight()
        );

    }

    @Override
    public void update(Product product) {

    }


    public void deleteById(Long id) {

    }

    public List<Product> getByType(String type){
        return null;
    }

    @Override
    public List<Product> getAll() {
         return jdbc.query(
                "select * from product",
                new ProductMapper()
        );
    }
}
