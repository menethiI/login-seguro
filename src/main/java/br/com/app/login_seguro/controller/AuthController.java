package br.com.app.login_seguro.controller;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import br.com.app.login_seguro.dto.UserDTO;
import br.com.app.login_seguro.service.UserService;

@Controller
public class AuthController {

    private final UserService service;

    public AuthController(UserService service) {
        this.service = service;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/cadastro")
    public String cadastroForm(Model model) {
        model.addAttribute("usuario", new UserDTO());
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute("usuario") @Valid UserDTO dto) {
        service.cadastrar(dto);
        return "redirect:/login?cadastro";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}