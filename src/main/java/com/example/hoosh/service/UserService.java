package com.example.hoosh.service;

import com.example.hoosh.model.User;
import com.example.hoosh.model.dto.UserDto;

public interface UserService {
    User createUser(UserDto userDto);

    User findByUsername(String username);
}
