package com.example.demo.repository;

import com.example.demo.entity.Klijent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KlijentRepository extends JpaRepository<Klijent,Long> {
}
