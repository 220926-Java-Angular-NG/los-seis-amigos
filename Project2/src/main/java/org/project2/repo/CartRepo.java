package org.project2.repo;

import org.project2.model.CartItem;
import org.project2.util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// TODO: implement skeleton code
public class CartRepo {
    Connection connection;

    // trying out methods on this repo
    public static void main(String[] args) {
        CartRepo crepo = new CartRepo();
        System.out.println(crepo.updateCartItemQuantity(1, 1, 1573));
        System.out.println(crepo.getCartItemsByUserId(1));
        System.out.println(crepo.removeFromCart(1, 1));
        System.out.println(crepo.getCartItemsByUserId(1));
        System.out.println(crepo.addItemToCart(1, 1, 321));
        System.out.println(crepo.addItemToCart(1, 1, 321));
        System.out.println(crepo.addItemToCart(1, 1, 321));
        System.out.println(crepo.getCartItemsByUserId(1));
        System.out.println(crepo.emptyUserCartByUserId(1));
        System.out.println(crepo.getCartItemsByUserId(1));
    }

    public CartRepo() {
        try {
            this.connection  = ConnectionManager.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // will get the users cart from the DB using users -> userId
    List<CartItem> getCartItemsByUserId (int userId) {
        try {
        String sql = "SELECT * FROM cart JOIN packs on cart.packid = packs.packid where userId = ?";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, userId);
        ResultSet rs = psmt.executeQuery();
        List<CartItem> cartItems = new ArrayList<>();
        while (rs.next()) {
            //(int packId, String setName, int quantity)
            cartItems.add( new CartItem(
                    rs.getInt("packId"),
                    rs.getString("setName"),
                    rs.getInt("quantity")
            ));
        }
        return cartItems;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    // will update the quantity of an item in the cart
    boolean updateCartItemQuantity (int userId, int packId, int quantity) {
        try {
            String sql = "UPDATE cart set quantity = ? where userId = ? AND packId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, quantity);
            psmt.setInt(2, userId);
            psmt.setInt(3, packId);
            int numberUpdated = psmt.executeUpdate();
            return numberUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // will remove a cart item from the cart with the userId and packUd
    boolean removeFromCart (int userId, int packId) {
        try {
            String sql = "DELETE FROM cart where userId = ? AND packId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, userId);
            psmt.setInt(2, packId);
            int numberUpdated = psmt.executeUpdate();
            return numberUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // will empty the entire cart of a user with userId
    boolean emptyUserCartByUserId (int userId) {
        try {
            String sql = "DELETE FROM cart where userId = ?";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, userId);
            int numberUpdated = psmt.executeUpdate();
            return numberUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    // adds an item to the cart, will return cartId
    boolean addItemToCart (int userId, int packId, int quantity) {
        try {
            String sql = "INSERT INTO cart (userId, packId, quantity) VALUES (?,?,?)";
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, userId);
            psmt.setInt(2, packId);
            psmt.setInt(3, quantity);
            int numberUpdated = psmt.executeUpdate();
            return numberUpdated > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
