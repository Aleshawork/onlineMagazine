package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dto.ClientAuthDto;
import com.unproject.onlineMagazine.model.dto.ClientCreationDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("api/")
public class AuthController {

    @Value("${auth.admin.password}")
    String password;

    @Value("${auth.admin.login}")
    String login;

    @GetMapping("/auth")
    public String addClient(Model model){
        ClientAuthDto clientAuthDto = new ClientAuthDto();
        model.addAttribute("clientAuth",clientAuthDto);
        return "start";
    }

    @PostMapping("/auth")
    public String saveClient(
            Model model,
            @ModelAttribute("clientAuth") ClientAuthDto clientAuthDto){

        if(clientAuthDto.getLogin().equals(login) && clientAuthDto.getPassword().equals(password)){
            return "index";
        }
        return "start";
    }
}
