package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.services.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //
@RequiredArgsConstructor
@RequestMapping("/sets")
public class SetController {
    private final SetService setService;

    @GetMapping("/names")
    public List<String> setNames(){
        return setService.findSet_Names();
    }
    @GetMapping("/codes")
    public List<String> setCodes(){
        return setService.findSetcodes();
    }

//    @GetMapping("/pack_image/{code}")
//    public String getUserByEmail(@PathVariable String code){
//        userRepository.findById(id).orElseThrow(() -> new RuntimeException("user not found with id " + id));
//
//        return setService.getSetCode(code);
//    }

//    @GetMapping("/email/{email}")
//    public User getUserByEmail(@PathVariable String email){
//        return userService.getUserByEmail(email);
//    }
}
