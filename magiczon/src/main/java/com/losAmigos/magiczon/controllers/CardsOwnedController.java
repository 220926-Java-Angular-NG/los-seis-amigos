package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.services.CardsOwnedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@RequestMapping("/collection")
@CrossOrigin(origins = "http://localhost:4200")
public class CardsOwnedController {

    private final CardsOwnedService cardsOwnedService;

    @GetMapping("/userId={userId}/display")
    @ResponseBody
    public List<CardsOwned> getUserCollection(@PathVariable Long userId){
        return cardsOwnedService.getUserCollection(userId);
    }
    @GetMapping("/{userId}/{setcode}")
    @ResponseBody
    public List<CardsOwned> getUserOwnOfSet(@PathVariable Long userId,@PathVariable String setcode){
        return cardsOwnedService.getUserOwnOfSet(userId,setcode);
    }

    @PostMapping("/userId={userId}/add-card")
    public CardsOwned addToCollection(@PathVariable Long userId, @RequestBody String img){
        return cardsOwnedService.addToCollection(userId,img);
    }
    @GetMapping("/sets/{userId}")
    @ResponseBody
    public Set<String> getUserOwnOfSet(@PathVariable Long userId){
        return cardsOwnedService.getSetsUserOwns(userId);
    }

    @PostMapping("/{userId}/{setcode}")
    public List<CardsOwned> addSetToCollection(@PathVariable Long userId, @PathVariable String setcode){
        return cardsOwnedService.addSetToCollection(userId,setcode);
    }

}
