package com.example.demo.entity;

public class Deo {
    private Long idDela;
    private String sifraDela;
    private String brendDela;
    private String tipDela;
    private Integer kolicina;
    private Double cena;

    public Deo() {
    }

    public Long getIdDela() {
        return idDela;
    }

    public void setIdDela(Long idDela) {
        this.idDela = idDela;
    }

    public String getSifraDela() {
        return sifraDela;
    }

    public void setSifraDela(String sifraDela) {
        this.sifraDela = sifraDela;
    }

    public String getBrendDela() {
        return brendDela;
    }

    public void setBrendDela(String brendDela) {
        this.brendDela = brendDela;
    }

    public String getTipDela() {
        return tipDela;
    }

    public void setTipDela(String tipDela) {
        this.tipDela = tipDela;
    }

    public Integer getKolicina() {
        return kolicina;
    }

    public void setKolicina(Integer kolicina) {
        this.kolicina = kolicina;
    }

    public Double getCena() {
        return cena;
    }

    public void setCena(Double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "Deo{" +
                "idDela=" + idDela +
                ", sifraDela='" + sifraDela + '\'' +
                ", brendDela='" + brendDela + '\'' +
                ", tipDela='" + tipDela + '\'' +
                ", kolicina=" + kolicina +
                ", cena=" + cena +
                '}';
    }
}
