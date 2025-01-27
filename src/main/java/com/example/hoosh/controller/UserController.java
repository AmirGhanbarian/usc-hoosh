package com.example.hoosh.controller;

import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "add-user";
    }

    @PostMapping
    public String register(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
    }
}
