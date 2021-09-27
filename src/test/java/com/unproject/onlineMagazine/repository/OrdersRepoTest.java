package com.unproject.onlineMagazine.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import static org.junit.jupiter.api.Assertions.*;
@JdbcTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class})
@PropertySource("classpath:application-test.properties")
@Import(OrdersRepo.class)
class OrdersRepoTest {
    @Autowired
    private OrdersRepo ordersRepo;

    @Test
    void getById() {

    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getAll() {
    }
}