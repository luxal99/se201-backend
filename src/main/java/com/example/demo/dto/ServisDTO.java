package com.example.demo.dto;

import com.example.demo.entity.Klijent;
import com.example.demo.entity.MehanickiServis;
import com.example.demo.entity.ServisKlime;
import com.example.demo.entity.ServisUlja;

public class ServisDTO {
    private Long idService;
    private ServisKlime idServisKlime;
    private ServisUlja idServisUlja;
    private MehanickiServis idMehanickiServis;
    private String date;
    private String time;
    private String type;
    private String car;
    private String carModel;
    private Klijent klijent;

    public ServisDTO() {
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public ServisKlime getIdServisKlime() {
        return idServisKlime;
    }

    public void setIdServisKlime(ServisKlime idServisKlime) {
        this.idServisKlime = idServisKlime;
    }

    public ServisUlja getIdServisUlja() {
        return idServisUlja;
    }

    public void setIdServisUlja(ServisUlja idServisUlja) {
        this.idServisUlja = idServisUlja;
    }

    public MehanickiServis getIdMehanickiServis() {
        return idMehanickiServis;
    }

    public void setIdMehanickiServis(MehanickiServis idMehanickiServis) {
        this.idMehanickiServis = idMehanickiServis;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

}
