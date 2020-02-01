package com.example.demo.controller;

import com.example.demo.entity.AvailableService;
import com.example.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("saveAvailableService")
    public ResponseEntity dodajTermin(@RequestBody AvailableService availableService){
        return ResponseEntity.ok(adminService.dodajTermin(availableService));
    }

}
