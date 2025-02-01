package com.example.hoosh.service;

import com.example.hoosh.model.User;
import com.example.hoosh.model.dto.UserDto;

import java.util.Optional;

public interface UserService {
    User createUser(UserDto userDto);

    Optional<User> findByUsername(String username);
    User grantContributorAccess(String username);
}
