package com.emissions.industrialemissionsmap.controller;

import com.emissions.industrialemissionsmap.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fantastic-friends/login")
public class LoginController {
    final
    UserRepository userRepository;

    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public String login() {
        return "login";
    }
}
