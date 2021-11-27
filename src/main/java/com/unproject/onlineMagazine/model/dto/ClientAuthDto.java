package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientAuthDto {
    private String login;
    private String password;
}
