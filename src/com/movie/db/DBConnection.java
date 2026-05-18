package com.movie.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

<<<<<<< HEAD
        try {

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/movieticketdb",
                    "root",
                    "Hari@020");

            System.out.println("Database Connected Successfully");

            return con;

        } catch(Exception e) {

            e.printStackTrace();
        }

        return null;
=======
        Connection con = null;

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/movie_booking_system",
                "root",
                "prash8088"
            );

            System.out.println("Database Connected Successfully");

        } catch(Exception e) {
            e.printStackTrace();
        }

        return con;
>>>>>>> 2b2b747cd47a55ef3424959b418ef16e01d2f181
    }
}