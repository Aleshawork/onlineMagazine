package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.TestDataHandler;
import com.unproject.onlineMagazine.model.dto.ClientInfoDto;
import com.unproject.onlineMagazine.repository.ClientRepo;
import com.unproject.onlineMagazine.repository.ContactRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class ClientServiceTest {

    @Mock
    ClientRepo clientRepo;

    @Mock
    ContactRepo contactRepo;

    @InjectMocks
    ClientService clientService;


    @Test
    void getPersonInformationByLoginTest() {
        when(clientRepo.findByLogin("Alesha")).thenReturn(
                TestDataHandler.getTestClient()
        );
        when(contactRepo.getById(1L)).thenReturn(
                TestDataHandler.getTestContact()
        );
        when(clientRepo.findByLogin("Ira")).thenThrow(new IncorrectResultSizeDataAccessException(12));

        ClientInfoDto testedObject = clientService.getPersonInformationByLogin("Alesha").get();
        assertEquals(testedObject.getClientPersonalDto().getEmail(),"alesha@mail.ru");
        assertEquals(testedObject.getContactDto().getAddress(),"Moscov, Popovo 21 2");

        Assertions.assertThrows(DataAccessException.class,
                ()->{
            clientRepo.findByLogin("Ira");
                });

    }

    void getAllPersonInformationTest(){

    }
}