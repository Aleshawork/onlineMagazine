package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.model.dao.Contact;
import com.unproject.onlineMagazine.model.dto.ClientCreationDto;
import com.unproject.onlineMagazine.model.dto.ClientInfoDto;
import com.unproject.onlineMagazine.model.dto.ClientPersonalDto;
import com.unproject.onlineMagazine.model.dto.ContactDto;
import com.unproject.onlineMagazine.repository.ClientRepo;
import com.unproject.onlineMagazine.repository.ContactRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ClientService {

    private  final ClientRepo clientRepo;
    private final ContactRepo contactRepo;


    @Autowired
    public ClientService(ClientRepo clientRepo, ContactRepo contactRepo) {
        this.clientRepo = clientRepo;
        this.contactRepo = contactRepo;
    }

    @Transactional
    public Optional<ClientInfoDto>  getPersonInformationByLogin(String login){
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
                         contact.getAddress(),
                         contact.getTelephoneNumber()
                    )
            );

        }catch(DataAccessException ex){
            log.warn("User with login:{} not found!",login);
            return Optional.empty();
        }
        return Optional.of(clientInfoDto);

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
                                    contact.getAddress(),
                                    contact.getTelephoneNumber()
                            )
                    )
            );
        }
        return clientInfoDtoList;
    }

    @Transactional
    public void addClient(ClientCreationDto clientDto){
        Contact contact = new Contact(
                clientDto.getAddress(),
                clientDto.getTelephone_number()
        );
        Long index = contactRepo.insertWithReturningId(contact);

        Client client = new Client(
                clientDto.getLogin(),
                clientDto.getPassword(),
                clientDto.getName(),
                clientDto.getEmail(),
                index,
                "on"
        );
        clientRepo.insert(client);
    }



}
