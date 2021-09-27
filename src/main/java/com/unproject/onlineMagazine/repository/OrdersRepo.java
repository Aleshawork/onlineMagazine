package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Orders;
import com.unproject.onlineMagazine.repository.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrdersRepo implements CrudOperations<Orders>{
    private  final JdbcOperations jdbc;

    @Autowired
    public OrdersRepo(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Orders getById(Long id) {
         return jdbc.queryForObject(
                "select * from orders where id=?",
                new OrdersMapper(),
                id
        );
    }

    @Override
    public void insert(Orders orders) {
        jdbc.update(
                "insert into orders(client_id,status,product_id,count,transaction_id) values(?,?,?,?,?)",
                orders.getClientId(),
                orders.getStatus(),
                orders.getProduct_id(),
                orders.getCount(),
                orders.getTransaction_id()
        );
    }

    @Override
    public void update(Orders orders) {
        //todo: обновлять только измененные поля
    }


    public void deleteById(Long id) {
        jdbc.update(
                "delete from orders where id=?",
                id
        );
    }

    @Override
    public List<Orders> getAll() {
        return jdbc.query(
                "select * from orders",
                new OrdersMapper()
        );
    }
}
