package com.example.demo.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double calculation;

    private String timestamp;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setCalculation(double calculation) {
        this.calculation = calculation;
    }
    public double getCalculation() {
        return calculation;
    }

    public void setTimestamp() {
        LocalDateTime now = LocalDateTime.now();
        timestamp = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
