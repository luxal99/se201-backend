package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

public class ServisUlja extends Servis{
    private String vrstaUlja;

    public ServisUlja() {
    }

    public String getVrstaUlja() {
        return vrstaUlja;
    }

    public void setVrstaUlja(String vrstaUlja) {
        this.vrstaUlja = vrstaUlja;
    }

    @Override
    public Long getIdService() {
        return super.getIdService();
    }

    @Override
    public void setIdService(Long idService) {
        super.setIdService(idService);
    }

    @Override
    public Klijent getIdClient() {
        return super.getIdClient();
    }

    @Override
    public void setIdClient(Klijent idClient) {
        super.setIdClient(idClient);
    }

    @Override
    public String getDate() {
        return super.getDate();
    }


    @Override
    public void setTime(String time) {
        super.setTime(time);
    }

    @Override
    public String getTime() {
        return super.getTime();
    }

    @Override
    public String toString() {
        return super.toString();
    }


}
