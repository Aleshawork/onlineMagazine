package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Contact;
import com.unproject.onlineMagazine.model.dao.Orders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@JdbcTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class})
@PropertySource("classpath:application-test.properties")
@Import(OrdersRepo.class)
class OrdersRepoTest {
    @Autowired
    private OrdersRepo ordersRepo;

    @Test
    void getById() {
        Orders orders = ordersRepo.getById(1L);
        assertEquals(orders.getClientId(),1);
        assertEquals(orders.getStatus(),"ready");
    }

    @Test
    void insert() {
        int START_COUNT = ordersRepo.getAll().size();
        ordersRepo.insert(
                new Orders(
                        2L,
                        "given",
                        2L,
                        1,
                        2L
                )
        );
        assertThat(ordersRepo.getAll().size()).isEqualTo(START_COUNT+1);
    }

    @Test
    void update() {

    }

    @Test
    void deleteById() {
    }

    @Test
    void getAll() {
        List<Orders> orders = ordersRepo.getAll();
        assertThat(orders.get(0).getCount()).isEqualTo(3);
        assertThat(orders.get(1).getStatus()).isEqualTo("given");
    }
}