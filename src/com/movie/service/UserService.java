package com.movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.movie.db.DBConnection;

public class UserService {

    Scanner sc = new Scanner(System.in);

    // REGISTER
    public void register() {

        try {

            System.out.print("Enter Username: ");
            String username = sc.next();

            System.out.print("Enter Email: ");
            String email = sc.next();

            System.out.print("Enter Password: ");
            String password = sc.next();

            Connection con =
                    DBConnection.getConnection();

            String query =
            "insert into users(username,email,password) values(?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int row = ps.executeUpdate();

            if(row > 0){

                System.out.println(
                "Registration Successful");
            }

        }

        catch(Exception e){

            if(e.getMessage().contains("Duplicate")){

                System.out.println(
                "Username or Email already exists");
            }
            else{

                e.printStackTrace();
            }
        }

    }



    // LOGIN
    public String login() {

        try {

            System.out.print(
            "Enter Username: ");

            String username =
                    sc.next();

            System.out.print(
            "Enter Password: ");

            String password =
                    sc.next();

            Connection con =
                    DBConnection.getConnection();

            String query =
            "select role from users where username=? and password=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs =
                    ps.executeQuery();

            if(rs.next()){

                String role =
                        rs.getString("role");

                System.out.println(
                "Login Successful");

                return role;
            }

        }

        catch(Exception e){

            e.printStackTrace();
        }

        System.out.println(
        "Invalid Username or Password");

        return null;

    }

}