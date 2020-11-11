package com.iabur.bs23.travel.controller;

import com.iabur.bs23.travel.dto.UserDto;
import com.iabur.bs23.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registerNewUser(Model model){
        model.addAttribute("userInformation", new UserDto());
        return "/register";
    }
    @PostMapping("/registration")
    public String registerNewUser(@ModelAttribute(name = "userInformation") UserDto userDto, Model model){
        userService.create(userDto);
        return "redirect:/login";
    }
}
