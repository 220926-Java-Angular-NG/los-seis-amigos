package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.Set;
import com.losAmigos.magiczon.services.SetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/getName/{setcode}")
    public Map<String, String> getNameBySetcode(@PathVariable String setcode){
        return setService.getNameBySetcode(setcode);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping("/setcode/{setcode}")
    public Set getSetWithSetCode(@PathVariable String setcode){
        return setService.findBySetCode(setcode);
    }

    @CrossOrigin("http://localhost:4200")
    @GetMapping
    public List<Set> getAllSets(){
        return setService.findAllSets();
    }

}
