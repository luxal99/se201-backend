package com.example.demo.controller;

import com.example.demo.dto.TipServisa;
import com.example.demo.entity.Servis;
import com.example.demo.entity.ServisKlime;
import com.example.demo.service.KlijentInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("client")
public class KlijentController {

    @Autowired
    private KlijentInterface klijentInterface;

    @PostMapping("scheduleItService/{tip}/{username}/{password}")
    public ResponseEntity scheduleItService(@RequestBody Servis servis,@PathVariable Integer tip,@PathVariable String username,@PathVariable String password) throws SQLException {
        return ResponseEntity.ok(klijentInterface.zakaziServis(servis,tip,username,password));
    }


}

