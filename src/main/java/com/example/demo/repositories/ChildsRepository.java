package com.example.demo.repositories;

import com.example.demo.models.Childs;
import com.example.demo.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChildsRepository extends JpaRepository<Childs, Long> {
    List<Childs> findByUserId(int user);

    List<Childs> findAllByUser(Users user);

}

