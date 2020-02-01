package com.example.demo.service;

import com.example.demo.dto.ServisDTO;
import com.example.demo.entity.AvailableService;
import com.example.demo.entity.Klijent;
import com.example.demo.entity.Servis;

import java.util.List;

public interface IServisKlijentService {
    Servis kreirajRezervisanServis(Servis servis);
    List<AvailableService> getAllAvailableService();
    List<ServisDTO> listaServisa(Long id);
    Klijent findClient(String username, String password);
}
