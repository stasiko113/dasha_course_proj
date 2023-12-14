package com.example.demo.services;

import com.example.demo.models.Users;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsersService {
    private final UserRepository userRepository;
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Users findByEmailOrPhone(String email) {
        return userRepository.findByEmailOrPhone(email, email);
    }

    public Users findById(int id) {
        return userRepository.findById(id);
    }

    public Users create(String name, String password, String userType, String imageUrl, String username, String genderType, String email, String phone) {
        Users user = new Users();
        user.create(name, password, userType, imageUrl, username, genderType, email, phone);
        userRepository.save(user);
        return user;
    }

}
