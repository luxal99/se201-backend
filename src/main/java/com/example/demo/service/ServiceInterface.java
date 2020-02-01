package com.example.demo.service;

import com.example.demo.entity.Klijent;

import java.sql.SQLException;

public interface ServiceInterface {
    public Klijent findClient(String username,String password) throws SQLException;
}
