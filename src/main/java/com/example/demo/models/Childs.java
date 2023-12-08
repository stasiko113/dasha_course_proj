package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "childs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Childs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "child")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<VisitToDoctor> visitToDoctors;
}