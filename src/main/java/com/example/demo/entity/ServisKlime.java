package com.example.demo.entity;

import java.sql.Time;
import java.util.Date;

public class ServisKlime extends Servis {
    private Long idServisKlime;
    private Integer kolicinaGasa;
    private Servis servis;

    public Servis getServis() {
        return servis;
    }

    public void setServis(Servis servis) {
        this.servis = servis;
    }

    public ServisKlime() {
    }

    public void setIdServisKlime(Long idServisKlime) {
        this.idServisKlime = idServisKlime;
    }

    public Integer getKolicinaGasa() {
        return kolicinaGasa;
    }

    public void setKolicinaGasa(Integer kolicinaGasa) {
        this.kolicinaGasa = kolicinaGasa;
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
