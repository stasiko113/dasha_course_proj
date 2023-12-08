package com.example.demo.repositories;

import com.example.demo.models.Childs;
import com.example.demo.models.VisitToDoctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisitToDoctorRepository extends JpaRepository<VisitToDoctor, Long> {
    List<VisitToDoctor> findAllByChild(Childs childs);
}
