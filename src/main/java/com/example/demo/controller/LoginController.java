package com.example.demo.controller;

import com.example.demo.model.Login;
import com.example.demo.repositorys.LoginRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final LoginRepo loginRepo;
    private final PasswordEncoder passwordEncoder;

    public LoginController(LoginRepo loginRepo, PasswordEncoder passwordEncoder) {
        this.loginRepo = loginRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register"; //

    }

    @PostMapping("/register")
    public String processRegister(@RequestParam String name,
                                  @RequestParam String password,
                                  Model model) {
        if (loginRepo.findByName(name).isPresent()) {
            model.addAttribute("message", "Benutzername existiert bereits!");
            return "register";
        }

        String encodedPassword = passwordEncoder.encode(password);
        Login user = new Login();
        user.setName(name);
        user.setPassword(encodedPassword);
        loginRepo.save(user);

        model.addAttribute("message", "Registrierung erfolgreich! Du kannst dich jetzt anmelden.");
        return "register";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }
}
