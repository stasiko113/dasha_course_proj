package com.example.demo.repositories;

import com.example.demo.models.SavedPractice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedPracticeRepository extends JpaRepository<SavedPractice, Long> {
}
