package com.unproject.onlineMagazine.service;

import com.unproject.onlineMagazine.model.dao.WareHouse;
import com.unproject.onlineMagazine.model.dto.WareHouseDto;
import com.unproject.onlineMagazine.repository.WareHouseRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class WareHouseService {
    private final WareHouseRepo wareHouseRepo;

    @Autowired
    public WareHouseService(WareHouseRepo wareHouseRepo) {
        this.wareHouseRepo = wareHouseRepo;
    }

    public List<WareHouse> findAll(){
        return wareHouseRepo.getAll();
    }

    public void save(WareHouseDto wareHouseDto){
        wareHouseRepo.insert(
                new WareHouse(
                        wareHouseDto.getName(),
                        wareHouseDto.getAddress()
                )
        );
        log.info("Add WareHouse with name: {}  and address: {}",wareHouseDto.getName(),wareHouseDto.getAddress());
    }
}
