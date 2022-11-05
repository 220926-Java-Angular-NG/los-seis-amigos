package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public User createUser(@RequestBody User user){

        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }


}
