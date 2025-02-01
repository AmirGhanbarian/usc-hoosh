package com.example.hoosh.controller;

import com.example.hoosh.model.User;
import com.example.hoosh.model.constant.RolesConstant;
import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.service.UserService;
import com.example.hoosh.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Role;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    @GetMapping("/admin/dashboard")
    public String adminDashboard() {
        return "Welcome, Admin!";
    }

    @GetMapping("/user/dashboard")
    public String userDashboard() {
        return "Welcome, User!";
    }
}