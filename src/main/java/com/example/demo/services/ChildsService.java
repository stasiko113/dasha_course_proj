package com.example.demo.services;

import com.example.demo.models.Childs;
import com.example.demo.models.Users;
import com.example.demo.models.VisitToDoctor;
import com.example.demo.repositories.ChildsRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.VisitToDoctorRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChildsService {
    private final ChildsRepository childRepository;
    private final UserRepository userRepository;
    private final VisitToDoctorRepository visitToDoctorRepository;
    public List<Childs> findByUserId(int id) {
        return childRepository.findByUserId(id);
    }

    public List<Childs> findByUser(int id) {
        return childRepository.findAllByUser(userRepository.findById(id));
    }
}
