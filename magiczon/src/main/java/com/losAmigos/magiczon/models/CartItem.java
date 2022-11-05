package com.losAmigos.magiczon.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name = "CartItem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItem extends Pack{

    int quantity;

    public CartItem(int packId, String setName) {
        super(packId, setName);
        this.quantity = 1;
    }

}
