package com.iabur.bs23.travel.controller;

import com.iabur.bs23.travel.model.User;
import com.iabur.bs23.travel.repositories.UserRepository;
import com.iabur.bs23.travel.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RootController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public RootController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;

    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        generateUsers();
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String showAllPrescription(){
        return "index";
    }

    private void generateUsers() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            var user = new User();
            user.setUsername("admin");
            user.setPassword(bCryptPasswordEncoder.encode("secret"));
            userRepository.save(user);
        }
    }
}
