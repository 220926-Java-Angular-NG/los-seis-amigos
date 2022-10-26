package org.project2.repo;

import org.project2.model.User;
import org.project2.util.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;

public class UserRepo {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepo.class);
    Connection conn;


    public UserRepo(){
        try{

            this.conn  = ConnectionManager.getConnection();
            System.out.println(conn.toString());
            System.out.println(conn.getSchema());
            System.out.println();

        }catch(SQLException sqlException){
            LOGGER.error(sqlException.getMessage());
        }
    }


    public int create(User user) {

        try{
            String sql = "INSERT INTO users (id,user_name,first_name,last_name,pass_word,email) VALUES (default,?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getFirstname());
            pstmt.setString(3,user.getLastname());
            pstmt.setString(4,user.getPassword());
            pstmt.setString(5,user.getEmail());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            return rs.getInt("id");
        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }

        return 0;
    }


    public List<User> getAll() {
        List<User> users = new ArrayList<>();

        try{

            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()){
                User user =new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));

                users.add(user);
            }

            return users;

        }catch(SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }

        return null;
    }


    public User getId(int id) {

        try{
            String sql = "SELECT * FROM users WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();

            User user = new User();

            while (rs.next()){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstname(rs.getString("first_name"));
                user.setLastname(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("pass_word"));

            }

            return user;

        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }



        return null;
    }


    public User update(User user) {

        try{
            String sql = "UPDATE users SET pass_word = ? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1,user.getPassword());
            pstmt.setInt(2,user.getId());
            ResultSet rs = pstmt.executeQuery();



            return user;

        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }


        return null;
    }


    public boolean delete(User user) {
        try{
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,user.getId());

            return pstmt.execute();

        }catch (SQLException sqlException){
            System.out.println(sqlException.getMessage());
        }



        return false;
    }






}
