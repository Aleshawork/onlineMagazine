package com.unproject.onlineMagazine.controller;

import com.unproject.onlineMagazine.model.dto.ClientAuthDto;
import com.unproject.onlineMagazine.model.dto.ClientCreationDto;
import com.unproject.onlineMagazine.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Objects;

/**
 * Стартовая страница необходимая для авторизации : {@linktourl http://localhost:8081/api/auth}
 */
@Controller
@RequestMapping("api/")
public class AuthController {

    @Autowired
    private AuthenticateService authenticateService;

    @Value("${web.main.url}")
    private String url;

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

    /**
     * В качестве аунтификации используется заглушка на одного
     * пользователя администратора
     * @param model
     * @param clientAuthDto
     * @return
     */
    @PostMapping("/auth")
    public String saveClient(
            Model model,
            @ModelAttribute("clientAuth") ClientAuthDto clientAuthDto){

        Role role = authenticateService.authenticateByLoginAndPassword(
                clientAuthDto.getLogin(),
                clientAuthDto.getPassword()
        );
        if(Objects.isNull(role) ) {
            return "start";
        } else if (Role.ADMIN.equals(role)) {
            model.addAttribute("mainurl",url);
            return "index";
        } else {
            model.addAttribute("mainurl",url);
            return "customer/customer_index";
        }

    }
}
