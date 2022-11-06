package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.repos.card.CardRepo;
import com.losAmigos.magiczon.repos.card.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
        // TO RUN UNCOMMENT THE FOLLOWING LINE
        this.initCardRepo();
    }

    public void initCardRepo(){

        CardRepo cardRepo = new CardRepo(cardRepository);
        cardRepo.getCardRepo();
    }



}
