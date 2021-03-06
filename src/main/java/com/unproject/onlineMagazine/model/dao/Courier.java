package com.unproject.onlineMagazine.model.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courier {
    private Long id;
    private String name;
    private int rating;
    private String telephoneNumber;
}
