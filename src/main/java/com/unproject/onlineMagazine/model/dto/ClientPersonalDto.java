package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientPersonalDto {
    private Long id;
    private String name;
    private String login;
    private String email;

    public ClientPersonalDto(String name, String login, String email) {
        this.name = name;
        this.login = login;
        this.email = email;
    }
}
