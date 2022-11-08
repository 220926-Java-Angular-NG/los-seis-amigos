package com.losAmigos.magiczon.repos.card;


import com.losAmigos.magiczon.models.Card;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.exception.DataException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

//@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class CardRepo {

    private final CardRepository cardRepository;


    public void getCardRepo(){
        if (!needToPopulate()) return;

//        CardRepo cardRepo = new CardRepo();
        int i = 0;

        do{
            if (this.tableExits()) {
                this.loadTable();
                break;
            }
            i++;
        }while(!this.tableExits()&&(i<10));

//        return this.getCardRepository();
    }


    private Boolean tableExits(){
        try {
            Long count = this.cardRepository.count();
            System.out.println(count);
            if(count >= 0) return true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
        }
        return false;
    }

    private boolean needToPopulate() {
        return this.cardRepository.count() == 0;
    }

    private boolean isBlank(Card card){
        if (card.getActualSet()==null||card.getActualSet().equals("")) return true;
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
                    //System.out.println(lineFromFile);
                    try {
                        Card card = new Card(lineFromFile);

                        if(card.getImgLocation()!=null){
                            this.cardRepository.save(card);
                        }
//                        if (card.getSetName() != null || card.getName() != null)
//                            this.cardRepository.save(card);
//
//                        if(!isBlank(card)){
//                            if (card.getSetName() != null || card.getName() != null) this.cardRepository.save(card);
//                        }

                    } catch (DataException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }

}
