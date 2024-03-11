package com.example.AulaCubeAssignment.Security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//Create a Class for password encode and decode
public class Config  {

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    public static String encode(String password) {
        return passwordEncoder.encode(password);
    }
    public static boolean matches(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }


}