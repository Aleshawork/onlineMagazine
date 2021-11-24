package com.unproject.onlineMagazine.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierDto {
    private String name;
    private int rating;
    private String telephoneNumber;
}
