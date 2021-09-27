package com.unproject.onlineMagazine.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private Long id;
    private String product_type;
    private String description;
    private int weight;

    public Product(String product_type, String description, int weight) {
        this.product_type = product_type;
        this.description = description;
        this.weight = weight;
    }
}
