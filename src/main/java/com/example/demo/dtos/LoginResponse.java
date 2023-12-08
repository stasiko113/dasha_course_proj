package com.example.demo.dtos;

import com.example.demo.models.Users;

public class LoginResponse {
    private String token;
    private Users existingUser;
    private String errorMessage;

    // Constructors, getters, and setters

    public LoginResponse(String token, Users existingUser) {
        this.token = token;
        this.existingUser = existingUser;
    }

    public LoginResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters and setters...

    // Other methods...
}