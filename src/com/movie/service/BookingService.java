package com.movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.movie.db.DBConnection;

public class BookingService {

    Scanner sc = new Scanner(System.in);

    // BOOK TICKET
    public void bookTicket() {

        try {

            System.out.println("\n===== AVAILABLE SHOWS =====");

            Connection con =
                    DBConnection.getConnection();

            String view =
            "select s.show_id,m.movie_name,t.theater_name,"
            + "s.show_date,s.show_time,s.ticket_price,"
            + "s.available_seats "
            + "from shows s "
            + "join movies m on s.movie_id=m.movie_id "
            + "join theaters t on s.theater_id=t.theater_id";

            PreparedStatement ps0 =
                    con.prepareStatement(view);

            ResultSet rs0 =
                    ps0.executeQuery();

            while(rs0.next()){

                System.out.println(
                rs0.getInt("show_id")+" | "
                +rs0.getString("movie_name")+" | "
                +rs0.getString("theater_name")+" | "
                +rs0.getDate("show_date")+" | "
                +rs0.getString("show_time")+" | "
                +"Seats:"+rs0.getInt("available_seats"));
            }

            System.out.print(
            "\nEnter User ID: ");

            int userId = sc.nextInt();

            System.out.print(
            "Enter Show ID: ");

            int showId = sc.nextInt();

            System.out.print(
            "Enter Seat Number: ");

            String seat = sc.next();

            String check =
            "select * from bookings where seat_number=? and show_id=?";

            PreparedStatement ps1 =
                    con.prepareStatement(check);

            ps1.setString(1,seat);
            ps1.setInt(2,showId);

            ResultSet rs =
                    ps1.executeQuery();

            if(rs.next()){

                System.out.println(
                "Seat already booked");

                return;
            }

            String query =
            "insert into bookings(user_id,show_id,"
            + "seat_number,status)"
            + " values(?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setInt(1,userId);
            ps.setInt(2,showId);
            ps.setString(3,seat);
            ps.setString(4,"BOOKED");

            int row =
                    ps.executeUpdate();

            if(row>0){

                System.out.println(
                "Ticket Booked Successfully");
            }

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }



    // VIEW BOOKINGS
    public void viewBookings() {

        try {

            Connection con =
                    DBConnection.getConnection();

            String query =
            "select * from bookings";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ResultSet rs =
                    ps.executeQuery();

            System.out.println(
            "\n===== BOOKING HISTORY =====");

            while(rs.next()){

                System.out.println(
                rs.getInt("booking_id")+" | "
                +rs.getInt("user_id")+" | "
                +rs.getInt("show_id")+" | "
                +rs.getString("seat_number")+" | "
                +rs.getString("status")+" | "
                +rs.getTimestamp("booking_date"));

            }

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }



    // CANCEL TICKET
    public void cancelTicket() {

        try {

            System.out.print(
            "Enter Booking ID: ");

            int id = sc.nextInt();

            Connection con =
                    DBConnection.getConnection();

            String query =
            "update bookings set status=? "
            + "where booking_id=?";

            PreparedStatement ps =
                    con.prepareStatement(query);

            ps.setString(1,"CANCELLED");
            ps.setInt(2,id);

            int row =
                    ps.executeUpdate();

            if(row>0)

                System.out.println(
                "Ticket Cancelled");

            else

                System.out.println(
                "Booking Not Found");

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }

}