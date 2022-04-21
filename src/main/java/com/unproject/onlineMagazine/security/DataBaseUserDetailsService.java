package com.unproject.onlineMagazine.security;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.repository.AuthenticateRepo;
import com.unproject.onlineMagazine.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Objects;

public class DataBaseUserDetailsService implements UserDetailsService {

    @Autowired
    private AuthenticateRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = repo.getClientByLogin(username);
        if (Objects.isNull(client)) {
            throw new UsernameNotFoundException("User not found");
        }
        return new User(client.getPassword(), client.getLogin());
    }
}
