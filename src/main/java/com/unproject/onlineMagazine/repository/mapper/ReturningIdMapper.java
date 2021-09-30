package com.unproject.onlineMagazine.repository.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class ReturningIdMapper implements RowMapper<Long> {
    @Override
    public Long mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Integer.toUnsignedLong(rs.getInt("id"));

    }
}
