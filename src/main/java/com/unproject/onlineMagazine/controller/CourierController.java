package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Courier;
import com.unproject.onlineMagazine.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("api/couriers")
public class CourierController {
    @Value("${web.main.url}")
    private String url;
    private final CourierService courierService;

    @Autowired
    public CourierController(CourierService courierService) {
        this.courierService = courierService;
    }

    @GetMapping("/all")
    public String getAll(Model model){
        List<Courier> couriers = courierService.findAll();
        model.addAttribute("couriers",couriers);
        model.addAttribute("mainurl",url);
        return "couriers";
    }
}
