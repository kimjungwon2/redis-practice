package com.example.pratice.caching.controller;

import com.example.pratice.caching.dto.User;
import com.example.pratice.caching.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{userId}/profile")
    public User getUser(@PathVariable(value="userId") String userId){
        return userService.getUser(userId);
    }
}
