package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Courier;
import com.unproject.onlineMagazine.repository.CourierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourierService {
    private final CourierRepo courierRepo;

    @Autowired
    public CourierService(CourierRepo courierRepo) {
        this.courierRepo = courierRepo;
    }

    public List<Courier> findAll(){
        return courierRepo.getAll();
    }
}
