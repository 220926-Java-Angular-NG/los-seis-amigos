package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.repos.CardsOwnedRepository;
import com.losAmigos.magiczon.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsOwnedService {

    private final CardsOwnedRepository cardsOwnedRepository;

    public CardsOwned addToCollection(Long id,String img){

        if(cardsOwnedRepository.existsByUseridAndImglocation(id,img)){
            cardsOwnedRepository.incrementQuantity(id,img);
            return cardsOwnedRepository.findByUseridAndImglocation(id,img)
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Could not find/update collection with user id " + id));
        }
        CardsOwned cardsOwned = new CardsOwned();
        cardsOwned.setUserId(id);
        cardsOwned.setImgLocation(img);
        cardsOwned.setQuantity(1);
        return cardsOwnedRepository.save(cardsOwned);

    }

    public List<CardsOwned> getUserCollection(User user){
        return getUserCollection(user.getId());
    }

    public List<CardsOwned> getUserCollection(Long id){
        return cardsOwnedRepository.findByUserid(id);
    }
}
