package com.example.demo.controller;

import com.example.demo.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("service")
public class ServisController {
    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping("getAvailableService")
    public ResponseEntity getAvailableService(){
        return ResponseEntity.ok(serviceInterface.dosputniTermini());
    }
}
