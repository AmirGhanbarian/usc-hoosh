package com.example.hoosh.service;

import com.example.hoosh.model.User;
import com.example.hoosh.model.constant.RolesConstant;
import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
//    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
//        this.passwordEncoder = new ;

    }

    @Override
    public User createUser(UserDto userDto) {

        User applicationUser = new User();
        applicationUser.setFirstName(userDto.getFirstName());
        applicationUser.setLastName(userDto.getLastName());
        applicationUser.setEmail(userDto.getEmail());
        applicationUser.setUsername(userDto.getUsername());
        applicationUser.setPassword(userDto.getPassword());
        applicationUser.setRoles(List.of(RolesConstant.STUDENT));
        return userRepository.save(applicationUser);

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
