package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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
}
