package com.unproject.onlineMagazine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private Long id;
    private Date dateOpen;

    public Transaction(Date dateOpen) {
        this.dateOpen = dateOpen;
    }
}
