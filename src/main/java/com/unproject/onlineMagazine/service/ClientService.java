package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.model.dao.Contact;
import com.unproject.onlineMagazine.model.dto.ClientInfoDto;
import com.unproject.onlineMagazine.model.dto.ClientPersonalDto;
import com.unproject.onlineMagazine.model.dto.ContactDto;
import com.unproject.onlineMagazine.repository.ClientRepo;
import com.unproject.onlineMagazine.repository.ContactRepo;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {

    private  final ClientRepo clientRepo;
    private final ContactRepo contactRepo;


    public ClientService(ClientRepo clientRepo, ContactRepo contactRepo) {
        this.clientRepo = clientRepo;
        this.contactRepo = contactRepo;
    }

    @Transactional
    public ClientInfoDto getPersonInformationByLogin(String login){
        ClientInfoDto clientInfoDto = new ClientInfoDto();
        try {
            Client client = clientRepo.findByLogin(login);
            Contact contact = contactRepo.getById(client.getContact_id());
            clientInfoDto.setClientPersonalDto(
                    new ClientPersonalDto(
                            client.getName(),
                            client.getLogin(),
                            client.getEmail()
                    )
            );
            clientInfoDto.setContactDto(
                    new ContactDto(
                         contact.getAdress(),
                         contact.getTelephoneNumber()
                    )
            );

        }catch(DataAccessException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        return clientInfoDto;

    }

    @Transactional
    public List<ClientInfoDto> getAllPersonInformation(){
        List<ClientInfoDto> clientInfoDtoList = new ArrayList<>();

        List<Client> allClientInfo = clientRepo.getAll();
        for(Client client:allClientInfo){
            Contact contact = contactRepo.getById(client.getContact_id());
            clientInfoDtoList.add(
                    new ClientInfoDto(
                            new ClientPersonalDto(
                                    client.getName(),
                                    client.getLogin(),
                                    client.getEmail()
                            ),
                            new ContactDto(
                                    contact.getAdress(),
                                    contact.getTelephoneNumber()
                            )
                    )
            );
        }
        return clientInfoDtoList;

    }
}
