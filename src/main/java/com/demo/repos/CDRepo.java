package com.demo.repos;

import com.demo.entities.CD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CDRepo extends JpaRepository<CD, Long> {
    CD findCDById(Long id);

    CD findCDByTitle(String title);

    List<CD> findAll();
}

