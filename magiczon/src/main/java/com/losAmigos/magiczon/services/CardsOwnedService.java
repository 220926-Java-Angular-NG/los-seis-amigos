package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.CardsOwned;
import com.losAmigos.magiczon.models.User;
import com.losAmigos.magiczon.repos.CardsOwnedRepository;
import com.losAmigos.magiczon.util.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardsOwnedService {

    private final CardsOwnedRepository cardsOwnedRepository;


    public List<CardsOwned> getUserCollection(Long id){
        return cardsOwnedRepository.findByUserId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Collections not found with user id: " + id));
    }

    public CardsOwned addToCollection(Long userId,String img){

        if(cardsOwnedRepository.existsByUserIdAndImgLocation(userId,img)){
            Long entryId = cardsOwnedRepository.findEntryIdByUserIdAndImgLocation(userId,img);
            CardsOwned updatedCol = cardsOwnedRepository.findById(entryId).
                    orElseThrow(() -> new RuntimeException("Could not update collection with user id " + userId));
            updatedCol.increment();
            return cardsOwnedRepository.save(updatedCol);
        }else{
            CardsOwned newCol = new CardsOwned();
            newCol.setImgLocation(img);
            newCol.setUserId(userId);
            newCol.setQuantity(1);
            System.out.println(newCol.toString());
            return addNewCollection(newCol);
        }


    }



    private CardsOwned addNewCollection(CardsOwned collection){
        return cardsOwnedRepository.save(collection);
    }

    public List<CardsOwned> getAllCollections(){
        return cardsOwnedRepository.findAll();
    }

}
