package com.example.demo.service;

import com.example.demo.entity.Klijent;
import com.example.demo.entity.Korisnik;

import java.sql.SQLException;

public interface RegistrationService {
    public Klijent saveClient(Klijent korisnik) throws SQLException;
    public String registerUser(Klijent klijent) throws SQLException;
}
