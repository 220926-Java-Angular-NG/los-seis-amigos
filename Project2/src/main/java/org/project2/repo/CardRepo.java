package org.project2.repo;

import org.project2.model.Card;
import org.project2.util.ConnectionManager;

import java.sql.*;

public class CardRepo {
// come back and implement crud dom interface
    Connection con;
    public CardRepo() {
        try {
            con = ConnectionManager.getConnection();
            System.out.println(con.getSchema());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public int create(Card card) {
        try {
            String sql = "INSERT INTO cards(cardid,name,setname,imagefile,actualset,color,colorid,concost,manavalue,type,power,toughness,loyalty,rarity,text) VALUES (default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, card.getName());
            pstmt.setString(2, card.getSetName());
            pstmt.setString(3, card.getImgLocation());
            pstmt.setString(4, card.getActualSet());
            pstmt.setString(5, card.getColor());
            pstmt.setString(6, card.getColorID());
            pstmt.setString(7, card.getCost());
            pstmt.setString(8, card.getConvertedCost());
            pstmt.setString(9, card.getType());
            pstmt.setString(10, card.getPower());
            pstmt.setString(11, card.getToughness());
            pstmt.setString(12, card.getLoyalty());
            pstmt.setString(13, card.getRarity());
            pstmt.setString(14, card.getText());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
