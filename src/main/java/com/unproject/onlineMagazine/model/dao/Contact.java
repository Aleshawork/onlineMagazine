package com.unproject.onlineMagazine.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String address;
    private String telephoneNumber;

    public Contact(String adress, String telephoneNumber) {
        this.address = adress;
        this.telephoneNumber = telephoneNumber;
    }
}

