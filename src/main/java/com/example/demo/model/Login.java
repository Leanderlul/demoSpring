package com.example.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String password;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

   public void setName(String name) {
        this.name = name;
   }

   public String getName() {
        return name;
   }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}