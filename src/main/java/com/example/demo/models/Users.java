package com.example.demo.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.io.Serializable;


@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Users implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = true, unique = true)
    private String phone;

    @Email
    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "gender_type")
    private String genderType;

    @Column(name = "user_type", nullable = false)
    private String userType;

    @ManyToOne
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Childs childs;

    public void create (String name, String password, String userType, String imageUrl, String username, String genderType, String email, String phone) {
        this.name = name;
        this.password = password;
        this.userType = userType;
        this.imageUrl = imageUrl;
        this.username = username;
        this.genderType = genderType;
        this.email = email;
        this.phone = phone;
    }

}

