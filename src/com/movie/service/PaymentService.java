package com.movie.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import com.movie.db.DBConnection;

public class PaymentService {

    Scanner sc = new Scanner(System.in);

    public void makePayment() {

        try {

            System.out.print(
            "Enter Booking ID: ");

            int bookingId = sc.nextInt();

            System.out.print(
            "Enter Amount: ");

            double amount = sc.nextDouble();

            System.out.println(
            "1.UPI");

            System.out.println(
            "2.Card");

            System.out.println(
            "3.Cash");

            int choice = sc.nextInt();

            String method="";

            switch(choice){

            case 1:
                method="UPI";
                break;

            case 2:
                method="CARD";
                break;

            case 3:
                method="CASH";
                break;
            }

            Connection con=
                    DBConnection.getConnection();

            String query=
            "insert into payments"
            + "(booking_id,amount,"
            + "payment_method,payment_status)"
            + " values(?,?,?,?)";

            PreparedStatement ps=
                    con.prepareStatement(query);

            ps.setInt(1,bookingId);
            ps.setDouble(2,amount);
            ps.setString(3,method);
            ps.setString(4,"SUCCESS");

            int row=
                    ps.executeUpdate();

            if(row>0)

                System.out.println(
                "Payment Successful");

        }

        catch(Exception e){

            e.printStackTrace();
        }

    }

}