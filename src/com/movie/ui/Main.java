package com.movie.ui;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(true) {

            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");

            System.out.println("1. Register");
            System.out.println("2. Exit");

            System.out.print("Choose Option: ");

            int choice = sc.nextInt();

            switch(choice) {

                case 1:
                    RegisterUI.register();
                    break;

                case 2:
                    System.out.println("Thank You");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
}