package com.movie.model;

public class User {

<<<<<<< HEAD
    private String username;
    private String email;
    private String password;

    public User() {}

    public User(String username,String email,String password){

        this.username=username;
        this.email=email;
        this.password=password;
=======
    private int userId;
    private String username;
    private String password;
    private String role;
    private String email;
    private String phone;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
>>>>>>> 2b2b747cd47a55ef3424959b418ef16e01d2f181
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
<<<<<<< HEAD
        this.username=username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
=======
        this.username = username;
>>>>>>> 2b2b747cd47a55ef3424959b418ef16e01d2f181
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
<<<<<<< HEAD
        this.password=password;
=======
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
>>>>>>> 2b2b747cd47a55ef3424959b418ef16e01d2f181
    }
}