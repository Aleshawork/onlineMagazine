package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dao.Client;
import com.unproject.onlineMagazine.model.dto.ClientCreationDto;
import com.unproject.onlineMagazine.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/client")
public class ClientController {


    @Value("${web.main.url}")
    private String url;
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public String start(Model model){
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        model.addAttribute("mainurl",url);
        return "index";
    }

    @GetMapping("/all")
    public String clients(Model model){
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        model.addAttribute("mainurl",url);
        return "clients";
    }

    @GetMapping("/addclient")
    public String addClient(Model model){
        ClientCreationDto client = new ClientCreationDto();
        model.addAttribute("clientDto",client);
        model.addAttribute("mainurl",url);
        return "addclient";
    }

    @PostMapping("/addclient")
    public String saveClient(
            Model model,
            @ModelAttribute("clientDto") ClientCreationDto clientDto){

        clientService.addClient(clientDto);
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        model.addAttribute("mainurl",url);
        return "clients";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(
            @PathVariable("id")int id,
            Model model
    ){
        clientService.delete(id);
        model.addAttribute("listClient",clientService.getAllPersonInformation());
        model.addAttribute("mainurl",url);
        return "clients";
    }

    @GetMapping("/{id}")
    public String findClientById(
            @PathVariable("id") int id,
            Model model
    ){
        model.addAttribute("client",clientService.findById(id));
        model.addAttribute("mainurl",url);
        return "client";
    }

}
