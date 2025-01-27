package com.example.hoosh.model;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//@Component
//public class CustomPasswordEncoder implements PasswordEncoder {☺
//
//    private final BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    public CustomPasswordEncoder() {
//        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public String encode(CharSequence rawPassword) {
//        return bCryptPasswordEncoder.encode(rawPassword);
//    }
//
//    @Override
//    public boolean matches(CharSequence rawPassword, String encodedPassword) {
//        return bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
//    }
//}