package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.repository.mapper.ClientMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class AuthenticateRepo {

    private  final NamedParameterJdbcOperations jdbc;

    public AuthenticateRepo(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    public Client getByNameAndPassword(String login, String password) {
        return jdbc.queryForObject(
                "select * from client where login =:login and password =:password",
                Map.of("login",login,
                        "password", password),
                new ClientMapper()
        );
    }

    public Client getClientByLogin(String username) {
        return jdbc.queryForObject(
                "select * from client where login=:login",
                Map.of("login",username),
                new ClientMapper()
        );
    }
}
