package com.example.demo.entity;

public class Zaposleni extends Korisnik{
    public Zaposleni() {
    }

    @Override
    public Long getIdKorisnik() {
        return super.getIdKorisnik();
    }

    @Override
    public void setIdKorisnik(Long idKorisnik) {
        super.setIdKorisnik(idKorisnik);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getLastname() {
        return super.getLastname();
    }

    @Override
    public void setLastname(String lastname) {
        super.setLastname(lastname);
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
