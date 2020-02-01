package com.example.demo.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.io.Serializable;

@JsonDeserialize(as=ServisKlime.class)
public abstract class Servis implements Serializable {
    private Long idService;
    private String date;
    private String time;
    private Klijent idClient;
    private String car;
    private String carModel;

    public Servis() {
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

    public Klijent getIdClient() {
        return idClient;
    }

    public void setIdClient(Klijent idClient) {
        this.idClient = idClient;
    }

    public Long getIdService() {
        return idService;
    }

    public void setIdService(Long idService) {
        this.idService = idService;
    }

    public String getDate() {
        return date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Servis{" +
                "idService=" + idService +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", idClient=" + idClient +
                '}';
    }
}
