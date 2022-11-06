package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.Card;
import com.losAmigos.magiczon.services.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cards")
public class CardController {
    private final CardService cardService;

    @GetMapping("/{id}")
    public Card findCardById(@PathVariable Long id) {
        return cardService.findCardById(id);
    }

    @GetMapping("/sets/{setName}")
    public List<Card> findCardsBySetName(@PathVariable String setName) {
        return cardService.findCardsBySet(setName);
    }

    @GetMapping("/sets")
    public List<String> findsetNames() {
      return cardService.findsetNames();
    }
}
