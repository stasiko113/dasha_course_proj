package com.example.demo.repositories;

import com.example.demo.models.SavedArticles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SavedArticlesRepository extends JpaRepository<SavedArticles, Long> {
}
