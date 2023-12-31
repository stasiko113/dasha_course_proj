package com.example.demo.repositories;

import com.example.demo.models.Childs;
import com.example.demo.models.Users;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail(String email);

    Users findById(int id);

    Users findByEmailOrPhone(@Email String email, String phone);
}
