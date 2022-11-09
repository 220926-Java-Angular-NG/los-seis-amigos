package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.Card;
import com.losAmigos.magiczon.repos.card.CardRepo;
import com.losAmigos.magiczon.repos.card.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        // will populate the MTG cards if there are none
        //this.initCardRepo();
    }
    public void initCardRepo(){
        CardRepo cardRepo = new CardRepo(cardRepository);
        cardRepo.getCardRepo();
    }

    public Card findCardById(Long id) {
        return cardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Card does not exist at card id: " + id)
        );
    }

    public List<Card> findCardsBySet(String setName) {
        return cardRepository.findCardsBySetName(setName);
    }

    public List<String> findsetNames () {
        return cardRepository.findDistinctSetNames();
    }



}
