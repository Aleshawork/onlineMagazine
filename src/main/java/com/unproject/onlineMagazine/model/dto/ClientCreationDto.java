package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClientCreationDto {
    private String login;
    private String password;
    private String name;
    private String email;
    private String address;
    private String telephone_number;
}
