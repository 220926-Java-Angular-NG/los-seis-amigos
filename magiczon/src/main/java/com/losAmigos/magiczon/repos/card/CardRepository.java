package com.losAmigos.magiczon.repos.card;

import com.losAmigos.magiczon.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {


}
