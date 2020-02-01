package com.example.demo.repository;


import com.example.demo.entity.AvailableService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailableServiceRepository extends JpaRepository<AvailableService,Long> {
}
