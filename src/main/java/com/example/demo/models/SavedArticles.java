package com.example.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "saved_articles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SavedArticles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users author;

    @ManyToOne
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Articles article;
}
