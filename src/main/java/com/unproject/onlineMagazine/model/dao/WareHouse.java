package com.unproject.onlineMagazine.model.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouse {
    private Long id;
    private String name;
    private String address;

    public WareHouse(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
