package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.repos.card.CardRepo;
import com.losAmigos.magiczon.repos.card.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService {

    private final CardRepository cardRepository = CardRepo.getCardRepo();



}
