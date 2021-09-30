package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.dao.WareHouse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WareHouseMapper implements RowMapper<WareHouse> {
    @Override
    public WareHouse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new WareHouse(
                rs.getLong("id"),
                rs.getString("name"),
                rs.getString("adress")
        );
    }
}
