package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Courier;
import com.unproject.onlineMagazine.repository.mapper.CourierMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CourierRepo implements CrudOperations<Courier> {

    private final JdbcOperations jdbc;

    @Autowired
    public CourierRepo(JdbcOperations jdbcOperations) {
        this.jdbc = jdbcOperations;
    }

    @Override
    public Courier getById(Long id) {
        return  jdbc.queryForObject(
                "select * from couriers where id=?",
                new CourierMapper(),
                id
                );
    }

    @Override
    public void insert(Courier courier) {
        jdbc.update(
                "insert into couriers(name,rating,telephone_number) values(?,?,?)",
                courier.getName(),
                courier.getRating(),
                courier.getTelephoneNumber()
        );
    }

    @Override
    public void update(Courier courier) {

    }

    @Override
    public List<Courier> getAll() {
        return jdbc.query(
                "select * from couriers",
                new CourierMapper()
        );
    }
    // todo:: add delete methode with cascade deleting

    public void delete(int id){
        jdbc.update(
                "delete from couriers where id=?",
                id

        );
    }

}
