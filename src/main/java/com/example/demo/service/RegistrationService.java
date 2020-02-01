package com.example.demo.service;

import com.example.demo.entity.Klijent;
import com.example.demo.entity.Korisnik;

public interface RegistrationService {
    Klijent registerClient(Klijent klijent);
    String createUser(Korisnik korisnik);
}
