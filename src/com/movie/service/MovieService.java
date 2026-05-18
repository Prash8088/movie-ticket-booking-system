package com.movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.movie.db.DBConnection;

public class MovieService {

    Scanner sc = new Scanner(System.in);

    // ADD MOVIE
    public void addMovie() {

        try {

            System.out.print("Movie Name: ");
            String movieName = sc.next();

            System.out.print("Genre: ");
            String genre = sc.next();

            System.out.print("Language: ");
            String language = sc.next();

            System.out.print("Duration: ");
            int duration = sc.nextInt();

            Connection con =
                    DBConnection.getConnection();

            String query =
            "insert into movies(movie_name,genre,language,duration) values(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1, movieName);
            ps.setString(2, genre);
            ps.setString(3, language);
            ps.setInt(4, duration);

            int row = ps.executeUpdate();

            if(row > 0){

                System.out.println(
                "Movie Added Successfully");
            }

        } catch(Exception e){

            e.printStackTrace();
        }
    }


    // VIEW MOVIES
    public void viewMovies() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
                    "select * from movies";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
            "\n===== MOVIE LIST =====");

            while(rs.next()){

                System.out.println(
                rs.getInt("movie_id")+" | "
                +rs.getString("movie_name")+" | "
                +rs.getString("genre")+" | "
                +rs.getString("language")+" | "
                +rs.getInt("duration")+" mins");

            }

        } catch(Exception e){

            e.printStackTrace();
        }
    }


    // UPDATE MOVIE
    public void updateMovie() {

        try {

            System.out.print(
            "Enter Movie ID: ");

            int id=sc.nextInt();

            System.out.print(
            "New Movie Name: ");

            String name=sc.next();

            Connection con=
                    DBConnection.getConnection();

            String query=
            "update movies set movie_name=? where movie_id=?";

            PreparedStatement ps=
                    con.prepareStatement(query);

            ps.setString(1,name);
            ps.setInt(2,id);

            int row=
                    ps.executeUpdate();

            if(row>0)

                System.out.println(
                "Movie Updated");

            else

                System.out.println(
                "Movie Not Found");

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }


    // DELETE MOVIE
    public void deleteMovie() {

        try {

            System.out.print(
            "Enter Movie ID: ");

            int id=sc.nextInt();

            Connection con=
                    DBConnection.getConnection();

            String query=
            "delete from movies where movie_id=?";

            PreparedStatement ps=
                    con.prepareStatement(query);

            ps.setInt(1,id);

            int row=
                    ps.executeUpdate();

            if(row>0)

                System.out.println(
                "Movie Deleted");

            else

                System.out.println(
                "Movie Not Found");

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }

}