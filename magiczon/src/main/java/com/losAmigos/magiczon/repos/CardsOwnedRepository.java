package com.losAmigos.magiczon.repos;

import com.losAmigos.magiczon.models.CardsOwned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsOwnedRepository extends JpaRepository<CardsOwned,Long> {

    @Query("SELECT imgLocation, quantity FROM cards_owned WHERE userId = ?1")
    Optional<String[]> findDataByUserId(Long id);


    @Query("UPDATE cards_owned SET quantity = quantity + 1 WHERE userId = ?1 AND imgLocation = ?2")
    void incrementQuantity(Long id,String img);

    boolean existsByUseridAndImglocation(Long id,String img);

    Optional<CardsOwned> findByUseridAndImglocation(Long id,String img);

    List<CardsOwned> findByUserid(Long id);

}
