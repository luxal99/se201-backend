package com.example.demo.controller;

public class SlobodniTermin {
    private Long idAvailableService;
    private String date;
    private String time;

    public SlobodniTermin() {
    }

    public Long getIdAvailableService() {
        return idAvailableService;
    }

    public void setIdAvailableService(Long idAvailableService) {
        this.idAvailableService = idAvailableService;
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

    @Override
    public String toString() {
        return "SlobodniTermin{" +
                "idAvailableService=" + idAvailableService +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
