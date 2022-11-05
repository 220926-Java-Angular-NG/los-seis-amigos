package com.losAmigos.magiczon.repos.card;


import com.losAmigos.magiczon.models.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

@RequiredArgsConstructor
@Getter
public class CardRepo {

    private CardRepository cardRepository;


    public static CardRepository getCardRepo(){

        CardRepo cardRepo = new CardRepo();

        do{
            if (cardRepo.tableExits()) {
                cardRepo.loadTable();
                break;
            }
        }while(!cardRepo.tableExits());

        return cardRepo.getCardRepository();
    }


    private Boolean tableExits(){
        try {
            if(this.cardRepository.count() >= 0) return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return false;
    }

    private void loadTable() {
        BufferedReader inputFile;
        // http://magicplugin.normalitycomics.com/update/cardFiles/
        // parent url containing the @urlsToCardInfo
        String[] urlsToCardInfo = {
                "http://magicplugin.normalitycomics.com/update/cardFiles/commander.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/custom-tokens-for-lackeyccg.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/intro-sets.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-core-sets.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-core-sets2.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-expansions.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-expansions2.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-expansions3.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/modern-only-sets.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/premodern-core-sets.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/premodern-expansions.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/premodern-expansions2.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/promos-and-alternates.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/reprint-only-sets.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/silver-border-and-special.txt",
                "http://magicplugin.normalitycomics.com/update/cardFiles/supplemental.txt"};
        // Link below contains url's each containing a portion of all card information based of release data
        // http://magicplugin.normalitycomics.com/update/cardFiles/
        for (String line : urlsToCardInfo) {
            try {
                inputFile = new BufferedReader(new InputStreamReader(new URL(line).openStream()));
                String lineFromFile;
                while ((lineFromFile = inputFile.readLine()) != null) {
                    this.cardRepository.save(new Card(lineFromFile));
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
