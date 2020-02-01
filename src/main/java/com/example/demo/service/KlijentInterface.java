package com.example.demo.service;

import com.example.demo.dto.TipServisa;
import com.example.demo.entity.Servis;
import com.example.demo.entity.ServisKlime;
import org.springframework.data.relational.core.sql.In;

import java.sql.SQLException;

public interface KlijentInterface {
    public String zakaziServis(Servis servis,Integer tip,String username,String password) throws SQLException;
}
