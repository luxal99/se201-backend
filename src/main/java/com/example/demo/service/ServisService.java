package com.example.demo.service;

import com.example.demo.entity.MehanickiServis;
import com.example.demo.entity.ServisKlime;
import com.example.demo.entity.ServisUlja;

public interface ServisService {
    String dodajServisKlime(ServisKlime servisKlime);
    String dodajServisUlja(ServisUlja servisUlja);
    String dodajMehanickiServis(MehanickiServis mehanickiServis);

}

