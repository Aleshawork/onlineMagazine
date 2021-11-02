package com.unproject.onlineMagazine.model.dto;

import lombok.*;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientInfoDto {

    private ClientPersonalDto clientPersonalDto;
    private ContactDto contactDto;
}
