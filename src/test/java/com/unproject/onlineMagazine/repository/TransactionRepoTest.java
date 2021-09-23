package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.sql.Date;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import(TransactionRepo.class)
class TransactionRepoTest {
    private int START_COUNT;

    @Autowired
    private TransactionRepo trRepo;

    @Test
    void getByIdTest() {
        assertThat(trRepo.getById(1L).getDateOpen()).hasSameTimeAs(Date.valueOf("2021-09-22"));
    }

    @Test
    void insertTest() {
        START_COUNT = trRepo.getAll().size();
        trRepo.insert(new Transaction(
                Date.valueOf("2021-09-19")
        ));
        List<Transaction> all = trRepo.getAll();
        assertThat(all.size()).isEqualTo(START_COUNT+1);
        assertThat(all.get(START_COUNT).getDateOpen()).hasSameTimeAs(Date.valueOf("2021-09-19"));
    }


    @Test
    void deleteByIdTest() {
        START_COUNT = trRepo.getAll().size();
        trRepo.insert(new Transaction(Date.valueOf("2021-09-19")));
        trRepo.deleteById((long) (START_COUNT+1));
        assertThat(trRepo.getAll().size()).isEqualTo(START_COUNT);
    }

    @Test
    void getAllTest() {
        List<Transaction> all = trRepo.getAll();
        assertThat(all.get(0).getDateOpen()).hasSameTimeAs(Date.valueOf("2021-09-22"));
        assertThat(all.get(1).getDateOpen()).hasSameTimeAs(Date.valueOf("2021-09-23"));
    }
}