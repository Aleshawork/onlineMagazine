package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.dao.Courier;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CourierMapper implements RowMapper<Courier> {
    @Override
    public Courier mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Courier(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getInt("rating"),
                rs.getString("telephone_number")
        );
    }
}
