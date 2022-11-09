package com.losAmigos.magiczon.controllers;

import com.losAmigos.magiczon.models.Cart;
import com.losAmigos.magiczon.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/item/{cartId}")
    public Cart findCartById(@PathVariable Long cartId) {
        return cartService.findCartById(cartId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{userId}")
    public List<Cart> getCartWithUserId(@PathVariable Long userId) {
        System.out.println("AKSJDHKAJSHDKAHDKSAKDSKJDH"+cartService.findAllWithUserId(userId));
        return cartService.findAllWithUserId(userId);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping("/item/{cartId}/quantity/{quantity}")
    public Cart updateCartQuantity(@PathVariable Long cartId, @PathVariable int quantity) {
        Cart cartInfo = cartService.findCartById(cartId);
        return cartService.updateCartQuantity(cartInfo, quantity);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/item/{cartId}")
    public boolean deleteCart(@PathVariable Long cartId) {
        return cartService.deleteCart(cartId);
    }

//    @CrossOrigin(origins = "http://localhost:4200")
//    @DeleteMapping("/item/set/{setCode}/user/{userId}")
//    public boolean deleteCartWithSetCode(@PathVariable String setCode, @PathVariable Long userId) {
//        return cartService.deleteCartWithSetCode(setCode, userId);
//    }
//    @GetMapping("/user/{")
//    @GetMapping
//    public List<Cart> getAllCarts() {
//        return cartService.findAllCarts();
//    }
}
