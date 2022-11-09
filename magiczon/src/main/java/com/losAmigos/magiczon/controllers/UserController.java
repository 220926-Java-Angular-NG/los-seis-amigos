package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController //
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        System.out.println(user.getFirstname() + " " + user.getLastname());
        return userService.registerUser(user);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/login")
    public User userLogin(@RequestBody User user){
        return userService.userLogin(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getById(userId);
    }

}
