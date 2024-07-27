package com.example.app.controller;

import com.example.app.model.User;
import com.example.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return userService.signup(user);
    }

    @PostMapping("/signin")
    public String signin(@RequestBody User user) {
        return userService.signin(user);
    }
}
