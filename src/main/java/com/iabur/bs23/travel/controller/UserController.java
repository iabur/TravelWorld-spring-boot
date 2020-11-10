package com.iabur.bs23.travel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/test")
    public String testf(){
        return "/register";
    }
}
