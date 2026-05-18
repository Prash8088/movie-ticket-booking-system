package com.movie.util;

public class ValidationUtil {

    public static boolean validUsername(String username){

        return username.matches(
        "^[A-Za-z0-9]{5,15}$");

    }

    public static boolean validPassword(String password){

        return password.matches(
        "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$");

    }

}