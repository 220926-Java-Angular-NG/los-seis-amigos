package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.Card;
import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.repos.CardsOwnedRepository;
import com.losAmigos.magiczon.repos.card.CardRepository;
import com.losAmigos.magiczon.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CardsOwnedService {

    private final CardsOwnedRepository cardsOwnedRepository;
    private final CardRepository cardsRepository;


    public List<CardsOwned> getUserCollection(Long id) {
        return cardsOwnedRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collections not found with user id: " + id));
    }

    public List<CardsOwned> addSetToCollection(Long userId, String setcode) {
        List<Card> setOfCards = cardsRepository.findCardsByActualSet(setcode);
        Random random = new Random();
        boolean hasMR = false;
        for (Card c : setOfCards)
            if (c.getRarity().equalsIgnoreCase("m"))
                hasMR = true;
        List<Card> setOfCommonCardswl = cardsRepository.findCardsByActualSetWhereRarity(setcode, "C");
        List<Card> setOfLands = new ArrayList<Card>();
        List<Card> setOfCommonCards = new ArrayList<Card>();
        for (Card c : setOfCommonCardswl) {
            if (c.getText() != null) {
                if (c.getType().toLowerCase().contains("land")) {
                    setOfLands.add(c);
                }
            } else {
                setOfCommonCards.add(c);
            }
        }

        List<Card> setOfUncommonCards = cardsRepository.findCardsByActualSetWhereRarity(setcode, "U");
        List<Card> setOfRareCards = cardsRepository.findCardsByActualSetWhereRarity(setcode, "R");
        List<Card> setOfMythicRareCards = new ArrayList<Card>();
        if (hasMR)
            setOfMythicRareCards = cardsRepository.findCardsByActualSetWhereRarity(setcode, "M");
        for (int i = 1; i < 10; i++)
            addToCollection(userId, setOfCommonCards.get(random.nextInt(setOfCommonCards.size())).getImgLocation());
        for (int i = 1; i < 3; i++)
            addToCollection(userId, setOfUncommonCards.get(random.nextInt(setOfUncommonCards.size())).getImgLocation());
        if (hasMR) {
            int i = random.nextInt(8);
            if (i == 1)
                addToCollection(userId, setOfMythicRareCards.get(random.nextInt(setOfMythicRareCards.size())).getImgLocation());
        } else
            addToCollection(userId, setOfRareCards.get(random.nextInt(setOfRareCards.size())).getImgLocation());
        System.out.println("Number of lands" + setOfLands.size());
        addToCollection(userId, setOfLands.get(random.nextInt(setOfLands.size())).getImgLocation());
        return getUserCollection(userId);
    }

    public CardsOwned addToCollection(Long userId, String img) {

        if (cardsOwnedRepository.existsByUserIdAndImgLocation(userId, img)) {
            Long entryId = cardsOwnedRepository.findEntryIdByUserIdAndImgLocation(userId, img);
            CardsOwned updatedCol = cardsOwnedRepository.findById(entryId).
                    orElseThrow(() -> new RuntimeException("Could not update collection with user id " + userId));
            updatedCol.increment();
            return cardsOwnedRepository.save(updatedCol);
        } else {
            CardsOwned newCol = new CardsOwned();
            newCol.setImgLocation(img);
            newCol.setUserId(userId);
            newCol.setQuantity(1);
            System.out.println(newCol.toString());
            return addNewCollection(newCol);
        }


    }


    private CardsOwned addNewCollection(CardsOwned collection) {
        return cardsOwnedRepository.save(collection);
    }

    public List<CardsOwned> getAllCollections() {
        return cardsOwnedRepository.findAll();
    }

    public List<CardsOwned> getUserOwnOfSet(Long userId, String setcode) {
        List<CardsOwned> allUserCards = this.getUserCollection(userId);
        List<CardsOwned> cardsOfASet = new ArrayList<CardsOwned>();
        for (CardsOwned c : allUserCards) {
            String[] sp = c.getImgLocation().split("/");
            String setcodeFromCardOwned = sp[0];
            if (setcodeFromCardOwned.equals(setcode)) {
                cardsOfASet.add(c);
            }
        }
        return cardsOfASet;
    }

    public Set<String> getSetsUserOwns(Long userId) {
        List<CardsOwned> allUserCards = this.getUserCollection(userId);
        Set<String> listOfSets = new TreeSet<String>();
        for (CardsOwned c : allUserCards) {
            listOfSets.add(c.getImgLocation().split("/")[0]);
        }
        return listOfSets;
    }

}
