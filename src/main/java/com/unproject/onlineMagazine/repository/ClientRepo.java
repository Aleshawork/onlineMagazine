package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.Client;
import com.unproject.onlineMagazine.repository.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;
import java.util.Map;

@Repository
public class ClientRepo implements CrudOperations<Client>{

    @Autowired
    private final NamedParameterJdbcOperations jdbc;


    public ClientRepo(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public Client getById(Long id) {
        return jdbc.queryForObject(
                "select * from client where id=:id",
                Map.of("id",id),
                new ClientMapper());
    }

    @Override
    public List<Client> getAll() {
        return jdbc.query(
                "select * from client",
                new ClientMapper()
        );
    }


    @Override
    public void insert(Client client) {

        jdbc.update("insert into client(login,password,name,email,contact_id) values(:login,:password,:name,:email,:contact_id)",
                Map.of(
                        "login",client.getLogin(),
                        "password",client.getPassword(),
                        "name", client.getName(),
                        "email",client.getEmail(),
                        "contact_id",client.getContact_id()));
    }

    @Override
    public void update(Client client) {
        //todo: замена только изменившихся полей
    }

    @Override
    public void deleteById(Long id) {

        jdbc.update(
                "delete from client where id=:id",
                Map.of("id",id));
    }

    public Client findByName(String name) {
        return jdbc.queryForObject(
                "select * from client where name=:name",
                Map.of("name",name),
                new ClientMapper());
    }

    public void deleteByContactId(Long id) {
        jdbc.update(
                "delete from client where contact_id=:contact_id",
                Map.of("contact_id",id)
        );
    }
}
