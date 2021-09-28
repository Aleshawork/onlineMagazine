package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String start(Model model){
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        return "start";
    }

    @GetMapping("/all")
    public String clients(Model model){
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        return "clients";
    }

}
