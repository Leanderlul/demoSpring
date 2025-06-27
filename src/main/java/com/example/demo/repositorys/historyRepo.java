package com.example.demo.repositorys;

import com.example.demo.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface historyRepo extends JpaRepository<History,Long>
{

}
