package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.dao.Orders;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrdersMapper implements RowMapper<Orders> {
    @Override
    public Orders mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Orders(
                resultSet.getLong("id"),
                resultSet.getLong("client_id"),
                resultSet.getString("status"),
                resultSet.getLong("product_id"),
                resultSet.getInt("count"),
                resultSet.getLong("transaction_id")
        );
    }
}
