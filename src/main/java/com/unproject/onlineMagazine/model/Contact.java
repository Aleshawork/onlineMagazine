package com.unproject.onlineMagazine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contact {
    private Long id;
    private String adress;
    private String telephoneNumber;

    public Contact(String adress, String telephoneNumber) {
        this.adress = adress;
        this.telephoneNumber = telephoneNumber;
    }
}
