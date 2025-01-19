package com.example.hoosh.service;

import com.example.hoosh.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User applicationUser =
                userService.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("User with username " + username + " does not exists");
        }
        UserDetails userDetails =
                org.springframework.security.core.userdetails.User.withUsername(username).password(applicationUser.getPassword()).roles("USER").disabled(false).build();
        return userDetails;
    }
}

