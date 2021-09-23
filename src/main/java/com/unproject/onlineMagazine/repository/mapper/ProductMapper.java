package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int i) throws SQLException {
        return new Product(
                rs.getLong("id"),
                rs.getString("product_type"),
                rs.getString("description"),
                rs.getInt("weight")
        );
    }
}
