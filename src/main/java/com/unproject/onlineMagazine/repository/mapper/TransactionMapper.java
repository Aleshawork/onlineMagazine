package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionMapper implements RowMapper<Transaction> {
    @Override
    public Transaction mapRow(ResultSet rs, int i) throws SQLException {
        return new Transaction(
                rs.getLong("id"),
                rs.getDate("date_open")
        );
    }
}
