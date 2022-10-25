package org.project2.repo;

import org.project2.model.Pack;

import java.util.List;

// TODO: implement skeleton code
public class CartRepo {

    // will get the users cart from the DB using users -> userId
    List<Pack> getCartItemsByUserId (int userId) {
        return null;
    }

    // will update the quantity of an item in the cart
    boolean updateCartItemQuantity (int cartId, int packId, int quantity) {
        return false;
    }

    // will remove a cart item from the cart with the cartId
    boolean removeFromCart (int cartId) {
        return false;
    }

    // will empty the entire cart of a user with userId
    boolean emptyUserCartByUserId (int userId) {
        return false;
    }

    // adds an item to the cart, will return cartId
    int addItemToCart (int userId, Pack pack, int quantity) {
        return 0;
    }
}
