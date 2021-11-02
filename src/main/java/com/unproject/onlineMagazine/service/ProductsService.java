package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Product;
import com.unproject.onlineMagazine.model.dto.ProductDto;
import com.unproject.onlineMagazine.repository.ProductRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
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

    public void save(ProductDto productDto){
        productRepo.insert(
                new Product(
                        productDto.getProductType(),
                        productDto.getDescription(),
                        productDto.getWeight()
                )
        );
        log.info("Add product: {} with type: {}",productDto.getDescription(),productDto.getProductType());
    }

    public Product getById(int id) {
       return productRepo.getById(Integer.toUnsignedLong(id));
    }
}
