package com.example.hoosh.controller;

import com.example.hoosh.model.dto.UserDto;
import com.example.hoosh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<HashMap<String, Object>> register(@RequestBody UserDto userDto) {
        var savedUser=userService.createUser(userDto);
        HashMap<String, Object> output = new HashMap<>();
        output.put("saved_user", savedUser);
        return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));
    }

//    @PostMapping("/adduser")
//    public String register(@Validated @ModelAttribute("user") UserDto userDto,
//                           BindingResult result) {
//        if (result.hasErrors()) {
//            return "add-user";
//        }
//        userService.createUser(userDto);
//        return "redirect:adduser?success";
//    }
}
