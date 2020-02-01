package com.example.demo.controller;

import com.example.demo.entity.Klijent;
import com.example.demo.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("registration")
public class RegistrationControler {
    @Autowired
    private RegistrationService registrationService;

    @PostMapping("registerUser")
    public ResponseEntity registerUser(@RequestBody Klijent klijent) throws SQLException {
        return ResponseEntity.ok(registrationService.registerUser(klijent));
    }
}
