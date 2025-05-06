package com.trimblecars.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "\"user\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}
