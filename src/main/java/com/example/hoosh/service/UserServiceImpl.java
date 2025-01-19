package com.example.hoosh.service;

import com.example.hoosh.model.User;
import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User createUser(UserDto userDto) {
        User applicationUser = new User();
        applicationUser.setFirstName(userDto.getFirstName());
        applicationUser.setLastName(userDto.getLastName());
        applicationUser.setEmail(userDto.getEmail());
        applicationUser.setUsername(userDto.getUsername());
        applicationUser.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(applicationUser);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
