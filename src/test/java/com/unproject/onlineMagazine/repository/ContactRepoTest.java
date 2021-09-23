package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@Import({ContactRepo.class,ClientRepo.class})
class ContactRepoTest {

    private static int START_COUNT;
    @Autowired
    private ContactRepo contactRepo;

    @Test
    void getById() {
        assertThat(contactRepo.getById(1L).getAdress()).isEqualTo("Moscov, Popovo 21 2");
        assertThat(contactRepo.getById(2L).getTelephoneNumber()).isEqualTo("89652075689");
    }

    @Test
    void insert() {
    START_COUNT = contactRepo.getAll().size();
    contactRepo.insert(new Contact(
            "Moscov Terrr 13",
            "89651872345"
    ));
    assertThat(contactRepo.getAll().size()).isEqualTo(START_COUNT+1);

    }

    @Test
    void deleteById() {
        START_COUNT = contactRepo.getAll().size();
        contactRepo.deleteById(2L);
        assertThat(contactRepo.getAll().size()).isEqualTo(START_COUNT-1);
    }

    @Test
    void getAll() {
        List<Contact> all = contactRepo.getAll();
        assertThat(all.get(0).getTelephoneNumber()).isEqualTo("89651085632");
        assertThat(all.get(1).getTelephoneNumber()).isEqualTo("89652075689");

    }
}