package com.unproject.onlineMagazine.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    private Long id;
    private Long clientId;
    private String status;
    private Long product_id;
    private int count;
    private Long transaction_id;

    public Orders(Long clientId, String status, Long product_id, int count, Long transaction_id) {
        this.clientId = clientId;
        this.status = status;
        this.product_id = product_id;
        this.count = count;
        this.transaction_id = transaction_id;
    }
}
