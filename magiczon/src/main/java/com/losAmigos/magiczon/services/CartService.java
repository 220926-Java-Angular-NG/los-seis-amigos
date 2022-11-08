package com.losAmigos.magiczon.services;

import com.losAmigos.magiczon.models.Cart;
import com.losAmigos.magiczon.repos.cart.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart findCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(()-> new RuntimeException("Can Not find Cart with Id: " + id));
    }

    public Cart createCart (Cart cart) {
        return cartRepository.save(cart);
    }

    public List<Cart> findAllWithUserId(Long userId) {
        return cartRepository.findAllByUserId(userId);
    }

//    @Deprecated
//    public List<Cart> findAllCarts() {
//        return  cartRepository.findAll();
//    }

    public Cart updateCartQuantity(Cart cart, int quantity) {
        cart.setQuantity(quantity);
        return cartRepository.save(cart);
    }

    public boolean deleteCart(Long cartId) {
        if (findCartById(cartId) == null) return false;
        cartRepository.deleteById(cartId);
        return true;
    }


}
