package com.losAmigos.magiczon.repos;

import com.losAmigos.magiczon.models.CardsOwned;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardsOwnedRepository extends JpaRepository<CardsOwned,Long> {



    @Query("UPDATE CardsOwned SET quantity = quantity + 1 WHERE userId = ?1 AND imgLocation = ?2")
    void incrementQuantity(Long userId,String img);

    @Query("UPDATE CardsOwned SET quantity = quantity + 1 WHERE entryId = ?1")
    void incrementQuantity(Long entryId);

    Optional<List<CardsOwned>> findByUserId(Long id);

    CardsOwned findByUserIdAndImgLocation(Long id,String img);

    Boolean existsByUserIdAndImgLocation(Long id,String img);

    Long findEntryIdByUserIdAndImgLocation(Long id,String img);

}
