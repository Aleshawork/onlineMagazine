package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.WareHouse;
import com.unproject.onlineMagazine.repository.mapper.WareHouseMapper;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WareHouseRepo implements CrudOperations<WareHouse> {
    private final JdbcOperations jdbc;

    public WareHouseRepo(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public WareHouse getById(Long id) {
        return jdbc.queryForObject(
                "select * from warehouse where id=?",
                new WareHouseMapper(),
                id
        );
    }

    @Override
    public void insert(WareHouse wareHouse) {
        jdbc.update(
                "insert into warehouse(name,adress) values(?,?)",
                wareHouse.getName(),
                wareHouse.getAddress()
        );
    }

    @Override
    public void update(WareHouse wareHouse) {
        //todo: make
    }

    @Override
    public List<WareHouse> getAll() {
        return jdbc.query(
                "select * from warehouse",
                new WareHouseMapper()
        );
    }
}
