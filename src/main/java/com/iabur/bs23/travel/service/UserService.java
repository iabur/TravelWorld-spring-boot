package com.iabur.bs23.travel.service;

import com.iabur.bs23.travel.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        var userFromDb = userRepository.findByUsername(s).orElseThrow(() ->
                new UsernameNotFoundException("No user found with this userName"));
        return new User(userFromDb.getUsername(), userFromDb.getPassword(), new ArrayList<>());
    }
}