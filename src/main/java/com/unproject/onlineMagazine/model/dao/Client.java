package com.unproject.onlineMagazine.model.dao;

import lombok.*;

@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client {
    private Long id;
    private String login;
    private String password;
    private String name;
    private String email;
    private Long contact_id;
    private String status;

    public Client(String login, String password, String name, String email, Long contact_id,String status) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.email = email;
        this.contact_id = contact_id;
        this.status = status;
    }
}
