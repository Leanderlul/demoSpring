package com.example.demo.repositorys;

import com.example.demo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepo extends JpaRepository<History, Long> {
    List<History> findTop10ByOrderByTimestampDesc();
}

