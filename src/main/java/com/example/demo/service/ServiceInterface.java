package com.example.demo.service;

import com.example.demo.controller.SlobodniTermin;
import com.example.demo.entity.Klijent;

import java.sql.SQLException;
import java.util.List;

public interface ServiceInterface {
    public Klijent findClient(String username,String password) throws SQLException;
    public List<SlobodniTermin> dosputniTermini();
}
