package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientInfoDto {

    private ClientPersonalDto clientPersonalDto;
    private ContactDto contactDto;
}
