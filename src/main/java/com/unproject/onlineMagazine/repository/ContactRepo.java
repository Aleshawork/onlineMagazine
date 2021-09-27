package com.unproject.onlineMagazine.repository;
import com.unproject.onlineMagazine.model.dao.Contact;
import com.unproject.onlineMagazine.repository.mapper.ContactMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class ContactRepo implements CrudOperations<Contact>{

    private final JdbcOperations jdbc;
    private final ClientRepo clientRepo;

    @Autowired
    public ContactRepo(JdbcOperations jdbc, ClientRepo clientRepo) {
        this.jdbc = jdbc;
        this.clientRepo = clientRepo;
    }


    @Override
    public Contact getById(Long id) {
        return jdbc.queryForObject(
                "select * from contact where id=?",
                new Object[]{id},
                new ContactMapper());
    }

    @Override
    public void insert(Contact contact) {
        jdbc.update(
                "insert into contact(adress,telephone_number) values(?,?)",
                    contact.getAdress(),
                    contact.getTelephoneNumber()
        );
    }

    @Override
    public void update(Contact contact) {
        //todo: обновлять только с изменившимися полями
    }


    @Override
    public List<Contact> getAll() {
        return jdbc.query("select * from contact",new ContactMapper());
    }
}
