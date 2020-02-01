package com.example.demo.controller;

import com.example.demo.entity.MehanickiServis;
import com.example.demo.entity.ServisKlime;
import com.example.demo.entity.ServisUlja;
import com.example.demo.service.ServisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("service")
public class ServisController {

    @Autowired
    private ServisService servisService;

    @PostMapping("saveOilService")
    public ResponseEntity saveOilService(@RequestBody ServisUlja servisUlja){
        return ResponseEntity.ok(servisService.dodajServisUlja(servisUlja));
    }

    @PostMapping("saveAcService")
    public ResponseEntity saveAcService(@RequestBody ServisKlime servisKlime){
        return ResponseEntity.ok(servisService.dodajServisKlime(servisKlime));
    }

    @PostMapping("saveMehanicService")
    public ResponseEntity saveMehanicService(@RequestBody MehanickiServis mehanickiServis){
        return ResponseEntity.ok(servisService.dodajMehanickiServis(mehanickiServis));
    }
}
