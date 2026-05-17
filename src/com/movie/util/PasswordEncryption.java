package com.movie.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Password Encryption Utility
 * Handles SHA-256 password encryption and verification
 */
public class PasswordEncryption {

    /**
     * Encrypt password using SHA-256
     * @param password Plain text password
     * @return Encrypted password
     */
    public static String encrypt(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(password.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Verify password against encrypted password
     * @param plainPassword Plain text password
     * @param encryptedPassword Encrypted password from database
     * @return true if password matches, false otherwise
     */
    public static boolean verify(String plainPassword, String encryptedPassword) {
        String encryptedInput = encrypt(plainPassword);
        return encryptedInput != null && encryptedInput.equals(encryptedPassword);
    }
}
