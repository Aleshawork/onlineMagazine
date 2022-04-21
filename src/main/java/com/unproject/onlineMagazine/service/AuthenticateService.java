package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.controller.Role;

public interface AuthenticateService {
    public Role authenticateByLoginAndPassword(String login,String password);
}
