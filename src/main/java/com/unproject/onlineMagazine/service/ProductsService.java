package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {
    private final  ProductRepo productRepo;

    @Autowired
    public ProductsService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAll(){
        return productRepo.getAll();
    }
}
