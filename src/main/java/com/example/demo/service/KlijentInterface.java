package com.example.demo.service;

import com.example.demo.dto.ServisDTO;
import com.example.demo.entity.Servis;

import java.sql.SQLException;
import java.util.List;

public interface KlijentInterface {
    public String zakaziServis(Servis servis, Integer tip, String username, String password) throws SQLException;
    public List<ServisDTO> getAllService(String username, String password);
}
