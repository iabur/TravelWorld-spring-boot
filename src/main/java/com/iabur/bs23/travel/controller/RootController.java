package com.iabur.bs23.travel.controller;

import com.iabur.bs23.travel.model.Location;
import com.iabur.bs23.travel.model.User;
import com.iabur.bs23.travel.repositories.LocationRepository;
import com.iabur.bs23.travel.repositories.UserRepository;
import com.iabur.bs23.travel.service.UserService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class RootController {

    private final UserRepository userRepository;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final LocationRepository locationRepository;

    public RootController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, UserService userService, LocationRepository locationRepository) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userService = userService;

        this.locationRepository = locationRepository;
    }

    @GetMapping("/login")
    public String login(Model model, @RequestParam(name = "error", required = false) String error) {
        generateUsers();
        createDummyLocation();
        model.addAttribute("error", error);
        return "login";
    }

    @GetMapping("/")
    public String showIndex(){
        return "index";
    }

    private void generateUsers() {
        if (userRepository.findByEmail("admin@admin.com").isEmpty()) {
            var user = new User();
            user.setEmail("admin@admin.com");
            user.setPassword(bCryptPasswordEncoder.encode("secret"));
            userRepository.save(user);
        }
    }

    public void createDummyLocation(){
        List<Location> locations = locationRepository.findAll();
        if(locations.isEmpty()) {
            Location location = new Location();
            location.setLocation("Dinajpur");
            locationRepository.save(location);

            Location location1 = new Location();
            location1.setLocation("Dhaka");
            locationRepository.save(location1);

            Location location2 = new Location();
            location2.setLocation("chittagong");
            locationRepository.save(location2);
        }
    }
}
