package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Transaction;
import com.unproject.onlineMagazine.repository.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepo implements CrudOperations<Transaction> {
    private final JdbcOperations jdbc;

    @Autowired
    public TransactionRepo(JdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Transaction getById(Long id) {
        return jdbc.queryForObject(
                "select * from transactions where id=?",
                new TransactionMapper(),
                id
        );
    }

    @Override
    public void insert(Transaction transaction) {
        jdbc.update(
                "insert into transactions(date_open) values(?)",
                transaction.getDateOpen()
        );
    }

    @Override
    public void update(Transaction transaction) {
        //todo:: обновить только изменившиеся записи
    }


    public void deleteById(Long id) {
        jdbc.update(
                "delete from transactions where id=?",
                id
        );
    }

    @Override
    public List<Transaction> getAll() {
        return jdbc.query(
                "select * from transactions",
                new TransactionMapper()
        );
    }


}
