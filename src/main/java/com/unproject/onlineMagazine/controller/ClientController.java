package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dto.ClientCreationDto;
import com.unproject.onlineMagazine.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        return "index";
    }

    @GetMapping("/all")
    public String clients(Model model){
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        return "clients";
    }

    @GetMapping("/addclient")
    public String addClient(Model model){
        ClientCreationDto client = new ClientCreationDto();
        model.addAttribute("clientDto",client);
        return "addclient";
    }

    @PostMapping("/addclient")
    public String saveClient(
            Model model,
            @ModelAttribute("clientDto") ClientCreationDto clientDto){

        clientService.addClient(clientDto);
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        return "clients";
    }

}
