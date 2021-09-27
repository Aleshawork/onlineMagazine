package com.unproject.onlineMagazine.repository.mapper;

import com.unproject.onlineMagazine.model.dao.Contact;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactMapper implements RowMapper<Contact> {
    @Override
    public Contact mapRow(ResultSet rs, int i) throws SQLException {
        return new Contact(
                rs.getLong("id"),
                rs.getString("adress"),
                rs.getString("telephone_number")
        );
    }
}
