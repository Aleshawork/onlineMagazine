package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.Courier;
import com.unproject.onlineMagazine.model.dto.CourierDto;
import com.unproject.onlineMagazine.repository.CourierRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class CourierService {
    private final CourierRepo courierRepo;

    @Autowired
    public CourierService(CourierRepo courierRepo) {
        this.courierRepo = courierRepo;
    }

    @Transactional
    public List<Courier> findAll(){
        return courierRepo.getAll();
    }

    @Transactional
    public void delete(int id) {
        courierRepo.delete(id);
        log.info("Delete courier with id:{}",id);
    }

    @Transactional
    public void save(CourierDto courierDto){
        courierRepo.insert(
                Courier.builder()
                        .name(courierDto.getName())
                        .rating(courierDto.getRating())
                        .telephoneNumber(courierDto.getTelephoneNumber())
                        .build()
        );
    }


}
