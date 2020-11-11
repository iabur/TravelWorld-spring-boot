package com.iabur.bs23.travel.service;

import com.iabur.bs23.travel.dto.UserDto;
import com.iabur.bs23.travel.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByEmail(s).orElseThrow(() ->
                new UsernameNotFoundException("No user found with this userName"));
        return new User(userFromDb.getEmail(), userFromDb.getPassword(), new ArrayList<>());
    }

    public void create(UserDto userDto){
        com.iabur.bs23.travel.model.User user = new com.iabur.bs23.travel.model.User();
        user.setName(userDto.getFirstName()+" "+userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }
}