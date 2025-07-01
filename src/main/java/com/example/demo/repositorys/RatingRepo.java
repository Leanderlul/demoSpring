package com.example.demo.repositorys;


import com.example.demo.model.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Ratings, Long> {
     List<Ratings> findAllByOrderByIdDesc();
}
