package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.services.CardsOwnedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/collection")
public class CardsOwnedController {

    private final CardsOwnedService cardsOwnedService;

    @GetMapping("/userId={id}/add-card")
    public List<CardsOwned> getUserCollection(@PathVariable Long id){
        return cardsOwnedService.getUserCollection(id);
    }

    @PostMapping("/userId={id}/display")
    public CardsOwned addToCollection(@PathVariable Long id,String img){
        return cardsOwnedService.addToCollection(id,img);
    }

}
