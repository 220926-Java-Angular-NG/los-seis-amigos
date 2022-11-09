package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.Card;
import com.losAmigos.magiczon.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/id/{id}")
    public Card findCardById(@PathVariable Long id) {
        return cardService.findCardById(id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sets/{setName}")
    public List<Card> findCardsBySetName(@PathVariable String setName) {
        return cardService.findCardsBySet(setName);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/sets")
    public List<String> findsetNames() {
      return cardService.findsetNames();
    }
}
