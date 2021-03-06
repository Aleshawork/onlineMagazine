package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Courier;
import com.unproject.onlineMagazine.model.dto.CourierDto;
import com.unproject.onlineMagazine.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") int id,
            Model model
            ){
        courierService.delete(id);
        model.addAttribute("couriers",courierService.findAll());
        model.addAttribute("mainurl",url);
        return "couriers";
    }

    @GetMapping()
    public String addCourier(Model model){
        CourierDto courierDto = new CourierDto();
        model.addAttribute("courier",courierDto);
        model.addAttribute("mainurl",url);
        return "addcourier";
    }

    @PostMapping()
    public String addCourier(
            Model model,
            @ModelAttribute("courier") CourierDto courierDto
    ){
        courierService.save(courierDto);
        model.addAttribute("mainurl",url);
        model.addAttribute("couriers",courierService.findAll());
        return "couriers";
    }
}
