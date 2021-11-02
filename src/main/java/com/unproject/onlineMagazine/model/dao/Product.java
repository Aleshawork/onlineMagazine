package com.unproject.onlineMagazine.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String productType;
    private String description;
    private double weight;

    public Product(String product_type, String description, double weight) {
        this.productType = product_type;
        this.description = description;
        this.weight = weight;
    }
}
