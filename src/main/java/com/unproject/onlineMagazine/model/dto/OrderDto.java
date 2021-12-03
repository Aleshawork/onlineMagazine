package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long clientId;
    private String status;
    private Long product_id;
    private int count;
    private Long transaction_id;
    private double totalPrice;
}
