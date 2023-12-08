package com.example.demo.controllers;
import com.example.demo.dtos.LoginResponse;
import com.example.demo.models.Childs;
import com.example.demo.security.JwtGenerator;

import com.example.demo.models.Users;
import com.example.demo.services.ChildsService;
import com.example.demo.services.UsersService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@RequiredArgsConstructor
public class UsersController {
    private final UsersService usersService;
    private final ChildsService childsService;
    private final Gson gson;

    private JwtGenerator jwtGenerator;

    @Autowired
    public void setJwtGenerator(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Users loginUser) {
        try {
            Users existingUser = usersService.findByEmail(loginUser.getEmail());

            if (existingUser == null || !existingUser.getPassword().equals(loginUser.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String token = jwtGenerator.generateToken(loginUser);

            LoginResponse loginResponse = new LoginResponse(token, existingUser);
            HashMap<String, String> map = new HashMap<>();
            map.put("id", existingUser.getEmail());
            map.put("name", existingUser.getName());
            map.put("userType", existingUser.getUserType());
            map.put("imageUrl", existingUser.getImageUrl());
            map.put("token", token);
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();  // Example: Print the stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/profile")
    public ResponseEntity<String> profile(@RequestParam(name = "id", required = true) int id) {
        try {
            Users existingUser = usersService.findById(id);

            if (existingUser == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Profile dont find");
            }

            HashMap<String, Object> map = new HashMap<>();

            if (existingUser.getUserType().equals("parent")) {
                List<Childs> childs = childsService.findByUser(id);
                map.put("childs", childs);
            }
            map.put("id", existingUser.getEmail());
            map.put("name", existingUser.getName());
            map.put("userType", existingUser.getUserType());
            map.put("imageUrl", existingUser.getImageUrl());
            map.put("phone", existingUser.getPhone());
            map.put("username", existingUser.getUsername());
            map.put("gender", existingUser.getGenderType());
            ObjectMapper response = new ObjectMapper();
            String json = response.writeValueAsString(map);
            return new ResponseEntity<>(json, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();  // Example: Print the stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/registration")
    public ResponseEntity<Map<String, Object>> registration(@RequestBody Users regUser) {
        try {
            Users existingUser = usersService.findByEmail(regUser.getEmail());

            if (existingUser != null) {
                HashMap<String, String> map = new HashMap<>();
                map.put("message", "Вы уже зарегистрированы");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            Users user = usersService.create(regUser.getName(), regUser.getPassword(), regUser.getUserType(), regUser.getImageUrl(), regUser.getUsername(), regUser.getGenderType(), regUser.getEmail());
            String token = jwtGenerator.generateToken(user);

            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("user", user);


            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            // Log the exception or handle it appropriately
            e.printStackTrace();  // Example: Print the stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}