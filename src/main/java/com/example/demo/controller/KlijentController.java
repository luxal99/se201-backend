package com.example.demo.controller;

import com.example.demo.entity.Servis;
import com.example.demo.service.IServisKlijentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("client")
public class KlijentController {

    @Autowired
    private IServisKlijentService iServisKlijentService;

    @GetMapping("getAllAvailableService")
    public ResponseEntity getAll() {
        return ResponseEntity.ok(iServisKlijentService.getAllAvailableService());
    }

    @PostMapping("schedulingService")
    public ResponseEntity schedulingService(@RequestBody Servis service){
        return ResponseEntity.ok(iServisKlijentService.kreirajRezervisanServis(service));
    }

    @GetMapping("findClient/{username}/{password}")
    public ResponseEntity findClient(@PathVariable String username,@PathVariable String password){
        return ResponseEntity.ok(iServisKlijentService.findClient(username,password));
    }

    @GetMapping("getAllServices/{id}")
    public ResponseEntity getAllService(@PathVariable Long id){
        return ResponseEntity.ok(iServisKlijentService.listaServisa(id));
    }
}

