package com.unproject.onlineMagazine.repository;

import com.unproject.onlineMagazine.model.dao.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest(excludeAutoConfiguration = {FlywayAutoConfiguration.class})
@PropertySource("classpath:application-test.properties")
@Import(ClientRepo.class)
class ClientRepoTest {

    private static int START_COUNT;

    @Autowired
    private ClientRepo clientRepo;


    @Test
    void getById() {
        assertThat(clientRepo.getById(1L).getName()).isEqualTo("Alexey");
    }


    @Test
    void getAll() {
        List<Client> all = clientRepo.getAll();
        all.forEach(System.out::println);
        assertThat(clientRepo.getAll().size()).isEqualTo(2);
        assertThat(clientRepo.getAll().get(0).getName()).isEqualTo("Alexey");
        assertThat(clientRepo.getAll().get(1).getName()).isEqualTo("Egor");
    }


    @Test
    void insert() {
        START_COUNT = clientRepo.getAll().size();
        clientRepo.insert(new Client(
                "Irka",
                "1234",
                "Ira",
                "ira@mail.ru",
                2L,
                "on"
        ));
        assertThat(clientRepo.getAll().size()).isEqualTo(START_COUNT+1);
    }


    @Test
    void update() {
    }

    @Test
    void deleteById() {
        assertThat(clientRepo.getById(1L).getStatus()).isEqualTo("on");
        clientRepo.deleteById(1L);
        assertThat(clientRepo.getById(1L).getStatus()).isEqualTo("of");
    }


    @Test
    void findByName() {
        String TEST_NAME ="Alexey";
        System.out.println(clientRepo.getAll().size());
        assertThat(clientRepo.findByName(TEST_NAME)).isEqualTo(
                new Client(
                        1L,
                        "Alesha",
                        "1234",
                        "Alexey",
                        "alesha@mail.ru",
                        1L,
                        "on"
                )
        );
    }

    @Test
    void findByLogin(){
        String TEST_LOGIN_NAME="Alesha";
        assertThat(clientRepo.findByLogin(TEST_LOGIN_NAME)).isEqualTo(
                new Client(
                        1L,
                        "Alesha",
                        "1234",
                        "Alexey",
                        "alesha@mail.ru",
                        1L,
                        "on"
                )
        );

    }

}