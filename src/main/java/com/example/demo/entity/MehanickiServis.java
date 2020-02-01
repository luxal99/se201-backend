package com.example.demo.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MehanickiServis extends Servis {
    private Long idMehanicService;
    List<Deo> listaDelova = new ArrayList<>();

    public MehanickiServis() {
    }

    public Long getIdMehanicService() {
        return idMehanicService;
    }

    public void setIdMehanicService(Long idMehanicService) {
        this.idMehanicService = idMehanicService;
    }

    public List<Deo> getListaDelova() {
        return listaDelova;
    }

    public void setListaDelova(List<Deo> listaDelova) {
        this.listaDelova = listaDelova;
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
