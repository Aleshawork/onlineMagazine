package com.unproject.onlineMagazine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String email;
    private Long contact_id;

    public Client(String login, String password, String name, String email, Long contact_id) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.contact_id = contact_id;
    }
}
