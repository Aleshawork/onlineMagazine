package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.controller.Role;
import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.repository.AuthenticateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticateServiceImpl implements AuthenticateService{
    private final String ADMIN_STATUS = "AD";
    private final String USER_STATUS = "US";

    @Autowired
    private AuthenticateRepo authenticateRepo;

    @Nullable
    @Override
    public Role authenticateByLoginAndPassword(String login, String password) {
        Client client = authenticateRepo.getByNameAndPassword(login, password);
        if (Objects.isNull(client)) {
            return null;
        } else if ( ADMIN_STATUS.equals(client.getStatus())) {
            return Role.ADMIN;
        } else return Role.USER;
    }
}
