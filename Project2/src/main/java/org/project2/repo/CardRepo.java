package org.project2.repo;

import org.project2.model.Card;
import org.project2.util.ConnectionManager;

import java.io.*;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CardRepo {
    // come back and implement crud dom interface
    Connection con;

    public CardRepo() {
        try {
            con = ConnectionManager.getConnection();
            if (!this.exist()) {
                this.createTable();
            }
            this.loadTable();
            System.out.println("Current Schema: " + con.getSchema());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean exist() {
        try {
            String sql = "SELECT EXISTS (SELECT FROM cards)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
            //return rs.next()?true:false; not sure if this would be preferred by if else above
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean createTable() {
        try {
            String sql = "create table cards(cardid serial primary key," +
                    "name varchar(141) not null," +
                    "setname varchar(13)," +
                    "imagefile varchar(51) not null unique," +
                    "actualset varchar(4)," +
                    "color varchar(5)," +
                    "colorid varchar(5)," +
                    "concost varchar(46)," +
                    "manavalue varchar(7)," +
                    "type varchar(49)," +
                    "power varchar(10)," +
                    "toughness varchar(3)" +
                    ",loyalty varchar(1)," +
                    "rarity varchar(1)," +
                    "text varchar(907))";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                if (this.exist()) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    private void loadTable() {
        BufferedReader inputFile;
        String pathToResources = "src/main/resources/";
        File cardInfoFolder = new File(pathToResources+"cardinfo/");
        if (!cardInfoFolder.exists()) {
            cardInfoFolder.mkdirs();
        }
        // Link below contains url's each containing a portion of all card information based of release data
        // http://magicplugin.normalitycomics.com/update/cardFiles/
        ArrayList<String> sitelist = new ArrayList<String>(); // Hold the 13 paths from url above
        try {
            // Hardcoded paths in text file located in resources folder
            Scanner sc = new Scanner(new File(pathToResources+"sitelist.txt"));
            // Iterate through
            while (sc.hasNext()) {
                String line = sc.nextLine();// Stores line from file in a string literal
                //System.out.println("From site list file: " + line);// print pathToResources from sitelist
                sitelist.add(line);// Adds pathToResources into list of url
                try {
                    inputFile = new BufferedReader(new InputStreamReader(new URL(line).openStream()));
                    String lineFromFile;
                    while ((lineFromFile = inputFile.readLine()) != null) {
                        //System.out.println(lineFromFile);
                        this.create(new Card(lineFromFile));
                    }
                } catch (IOException e) {
                    System.out.println(e);
                }
                //nc.printMainDir();
            }
        } catch (Exception e) {
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
