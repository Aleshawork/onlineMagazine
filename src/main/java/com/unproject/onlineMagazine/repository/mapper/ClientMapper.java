package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.dao.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {
    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        return new Client(
                rs.getLong("id"),
                rs.getString("login"),
                rs.getString("password"),
                rs.getString("name"),
                rs.getString("email"),
                rs.getLong("contact_id"),
                rs.getString("status")
        );
    }
}
