package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.services.CardsOwnedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/collection")
public class CardsOwnedController {

    private final CardsOwnedService cardsOwnedService;

    @GetMapping("/userId={userId}/display")
    @ResponseBody
    public List<CardsOwned> getUserCollection(){
        return cardsOwnedService.getAllCollections();
    }

    @PostMapping("/userId={userId}/add-card")
    public CardsOwned addToCollection(@PathVariable Long userId, @RequestBody String img){
        return cardsOwnedService.addToCollection(userId,img);
    }

}