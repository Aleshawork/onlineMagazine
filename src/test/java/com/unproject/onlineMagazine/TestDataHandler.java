package com.unproject.onlineMagazine;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.model.dao.Contact;
import com.unproject.onlineMagazine.model.dto.ClientInfoDto;
import com.unproject.onlineMagazine.model.dto.ClientPersonalDto;
import com.unproject.onlineMagazine.model.dto.ContactDto;

public class TestDataHandler {
    public static Client getTestClient(){
        return new Client(
                1L,
                "Alesha",
                "1234",
                "Alexey",
                "alesha@mail.ru",
                1L,
                "on"
        );
    }

    public static Contact getTestContact(){
        return new Contact(
                "Moscov, Popovo 21 2",
                "89651085632"
        );
    }

    public static ClientPersonalDto getTestClientPersonalDto(){
        return new ClientPersonalDto(

                "Alexey",
                "Alesha",
                "alesha@mail.ru"
        );
    }

    public static ContactDto getTestContactDto(){
        return  new ContactDto(
                "'Moscov, Popovo 21 2",
                "89651085632"
        );
    }

    public ClientInfoDto getTestClientInfoDto(){
        return new ClientInfoDto(
                getTestClientPersonalDto(),
                getTestContactDto()
        );
    }
}
