package com.movie.dao;

<<<<<<< HEAD
public interface UserDAO {

    void register();

    boolean login();

=======
import java.sql.Connection;
import java.sql.PreparedStatement;

import com.movie.db.DBConnection;
import com.movie.model.User;

public class UserDAO {

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            Connection con = DBConnection.getConnection();

            String query =
            "INSERT INTO users(username,password,role,email,phone) VALUES(?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getRole());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getPhone());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return status;
    }
>>>>>>> 2b2b747cd47a55ef3424959b418ef16e01d2f181
}