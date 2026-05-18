package com.movie.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static Connection getConnection() {

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
    }
}