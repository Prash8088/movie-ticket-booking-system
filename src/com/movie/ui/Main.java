package com.movie.ui;

import java.util.Scanner;

import com.movie.service.BookingService;
import com.movie.service.MovieService;
import com.movie.service.PaymentService;
import com.movie.service.UserService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        UserService us = new UserService();

        while(true){

            System.out.println("\n=================================");
            System.out.println(" MOVIE TICKET BOOKING SYSTEM ");
            System.out.println("=================================");

            System.out.println("1.Register");
            System.out.println("2.Login");
            System.out.println("3.Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch(choice){

            case 1:

                us.register();
                break;

            case 2:

                String role = us.login();

                if(role != null){

                    MovieService ms =
                            new MovieService();

                    BookingService bs =
                            new BookingService();

                    PaymentService ps =
                            new PaymentService();

                    while(true){

                        System.out.println(
                        "\n===== DASHBOARD =====");

                        // ADMIN MENU
                        if(role.equalsIgnoreCase("ADMIN")){

                            System.out.println(
                            "1.Add Movie");

                            System.out.println(
                            "2.View Movies");

                            System.out.println(
                            "3.Update Movie");

                            System.out.println(
                            "4.Delete Movie");

                            System.out.println(
                            "5.Logout");

                            System.out.print(
                            "Enter Choice: ");

                            int ch = sc.nextInt();

                            switch(ch){

                            case 1:
                                ms.addMovie();
                                break;

                            case 2:
                                ms.viewMovies();
                                break;

                            case 3:
                                ms.updateMovie();
                                break;

                            case 4:
                                ms.deleteMovie();
                                break;

                            case 5:
                                System.out.println(
                                "Logged Out");
                                break;

                            default:
                                System.out.println(
                                "Invalid Choice");
                            }

                            if(ch==5)
                                break;
                        }

                        // USER MENU
                        else{

                            System.out.println(
                            "1.View Movies");

                            System.out.println(
                            "2.Book Ticket");

                            System.out.println(
                            "3.View Booking History");

                            System.out.println(
                            "4.Cancel Ticket");

                            System.out.println(
                            "5.Make Payment");

                            System.out.println(
                            "6.Logout");

                            System.out.print(
                            "Enter Choice: ");

                            int ch = sc.nextInt();

                            switch(ch){

                            case 1:
                                ms.viewMovies();
                                break;

                            case 2:
                                bs.bookTicket();
                                break;

                            case 3:
                                bs.viewBookings();
                                break;

                            case 4:
                                bs.cancelTicket();
                                break;

                            case 5:
                                ps.makePayment();
                                break;

                            case 6:
                                System.out.println(
                                "Logged Out");
                                break;

                            default:
                                System.out.println(
                                "Invalid Choice");
                            }

                            if(ch==6)
                                break;
                        }

                    }

                }

                break;

            case 3:

                System.out.println(
                "Thank You");

                System.exit(0);

                break;

            default:

                System.out.println(
                "Invalid Choice");
            }

        }

    }

}