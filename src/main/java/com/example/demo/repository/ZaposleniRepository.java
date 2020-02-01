package com.example.demo.repository;

import com.example.demo.entity.Zaposleni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ZaposleniRepository extends JpaRepository<Zaposleni,Long> {
}
