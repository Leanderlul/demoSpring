package com.example.demo.repositorys;

import com.example.demo.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login, Long> {
     Optional<Login> findByName(String name);
}