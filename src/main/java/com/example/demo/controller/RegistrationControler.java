package com.example.demo.controller;

import com.example.demo.entity.Klijent;
import com.example.demo.entity.Korisnik;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("registration")
public class RegistrationControler {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("saveClient")
    public ResponseEntity saveClient(@RequestBody Klijent klijent){
        return ResponseEntity.ok(registrationService.registerClient(klijent));
    }

    @PostMapping("saveUser")
    public ResponseEntity saveUser(@RequestBody Korisnik korisnik){
        return ResponseEntity.ok(registrationService.createUser(korisnik));
    }
}
