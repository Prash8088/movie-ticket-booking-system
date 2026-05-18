package com.movie.ui;

import java.util.Scanner;

import com.movie.dao.UserDAO;
import com.movie.model.User;

public class RegisterUI {

    public static void register() {

        Scanner sc = new Scanner(System.in);

        User user = new User();

        System.out.println("===== USER REGISTRATION =====");

        System.out.print("Enter Username: ");
        user.setUsername(sc.nextLine());

        System.out.print("Enter Password: ");
        user.setPassword(sc.nextLine());

        System.out.print("Enter Role: ");
        user.setRole(sc.nextLine());

        System.out.print("Enter Email: ");
        user.setEmail(sc.nextLine());

        System.out.print("Enter Phone: ");
        user.setPhone(sc.nextLine());

        UserDAO dao = new UserDAO();

        boolean result = dao.registerUser(user);

        if(result) {
            System.out.println("Registration Successful");
        } else {
            System.out.println("Registration Failed");
        }
    }
}