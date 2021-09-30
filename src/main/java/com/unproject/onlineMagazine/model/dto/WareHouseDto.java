package com.unproject.onlineMagazine.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WareHouseDto {
    private String name;
    private String address;

    public WareHouseDto(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
