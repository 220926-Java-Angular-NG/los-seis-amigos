package com.losAmigos.magiczon.repos.cart;

import com.losAmigos.magiczon.models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    List<Cart> findAllByUserId(Long id);
    @Transactional
    Integer deleteAllByUser_Id(long userId);
//    @Query("DELETE FROM carts WHERE ")
//    boolean deleteByUserIdAndSetcode(Long id, String setcode);
//    Cart
}
