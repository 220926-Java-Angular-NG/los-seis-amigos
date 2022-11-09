package com.losAmigos.magiczon.repos.card;

import com.losAmigos.magiczon.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

    List<Card> findCardsBySetName(String setName);
    @Query("SELECT DISTINCT d.setName FROM Card d")
    List<String> findDistinctSetNames();

    List<Card> findCardsByActualSet(String setcode);
    @Query("SELECT c from Card c where c.actualSet  = ?1 and c.rarity = ?2")
    List<Card> findCardsByActualSetWhereRarity(String setcode,String rarity);

    //get cards by set -> cards left get only { u(uncommon) - c(common) - r(rare) - m(mythic rare)}

}
