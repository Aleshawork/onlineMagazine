package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.WareHouse;
import com.unproject.onlineMagazine.model.dto.WareHouseDto;
import com.unproject.onlineMagazine.service.WareHouseService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/warehouse")
public class WareHouseController {
    @Value("${web.main.url}")
    private String url;
    private final WareHouseService wareHouseService;

    public WareHouseController(WareHouseService wareHouseService) {
        this.wareHouseService = wareHouseService;
    }

    @GetMapping("/all")
    public String findAll(Model model){
        List<WareHouse> wareHouses = wareHouseService.findAll();
        model.addAttribute("wareHouses",wareHouses);
        model.addAttribute("mainurl",url);
        return "warehouses";
    }

    @GetMapping("/addwarehouse")
    public String addWareHouse(Model model){
        WareHouseDto wareHouseDto = new WareHouseDto();
        model.addAttribute("wareHouseDto",wareHouseDto);
        model.addAttribute("mainurl",url);
        return "addwarehouse";
    }
    @PostMapping ("/addwarehouse")
    public String addWareHouse(
            Model model,
            @ModelAttribute("wareHouse") WareHouseDto wareHouseDto
    ){
        wareHouseService.save(wareHouseDto);
        model.addAttribute("mainurl",url);
        model.addAttribute("wareHouses",wareHouseService.findAll());
        return "warehouses";
    }
}
