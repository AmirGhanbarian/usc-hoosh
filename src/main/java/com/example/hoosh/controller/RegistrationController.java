package com.example.hoosh.controller;

import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/adduser")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());
        return "add-user";
    }

    @PostMapping("/adduser")
    public String register(@Validated @ModelAttribute("user") UserDto userDto,
                           BindingResult result) {
        if (result.hasErrors()) {
            return "add-user";
        }
        userService.createUser(userDto);
        return "redirect:adduser?success";
    }
}
