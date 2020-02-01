/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "servis")
public class Servis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_service")
    private Integer idService;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Basic(optional = false)
    @Column(name = "car")
    private String car;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "car_model")
    private String carModel;
    @JoinColumn(name = "id_client", referencedColumnName = "id_client")
    @ManyToOne
    @JsonBackReference
    private Klijent idClient;
    @OneToOne(mappedBy = "idService")
    @JsonManagedReference
    @JsonIgnore
    private ServisKlime servisKlime;
    @OneToOne(mappedBy = "idService")
    @JsonManagedReference
    @JsonIgnore
    private MehanickiServis mehanickiServis;
    @OneToOne(mappedBy = "idService")
    @JsonManagedReference
    @JsonIgnore
    private ServisUlja servisUlja;

    public Servis() {
    }

    public Servis(Integer idService) {
        this.idService = idService;
    }

    public Servis(Integer idService, String date, String car, String carModel) {
        this.idService = idService;
        this.date = date;
        this.car = car;
        this.carModel = carModel;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
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

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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


    public ServisKlime getServisKlime() {
        return servisKlime;
    }

    public void setServisKlime(ServisKlime servisKlime) {
        this.servisKlime = servisKlime;
    }

    public MehanickiServis getMehanickiServis() {
        return mehanickiServis;
    }

    public void setMehanickiServis(MehanickiServis mehanickiServis) {
        this.mehanickiServis = mehanickiServis;
    }

    public ServisUlja getServisUlja() {
        return servisUlja;
    }

    public void setServisUlja(ServisUlja servisUlja) {
        this.servisUlja = servisUlja;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idService != null ? idService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Servis)) {
            return false;
        }
        Servis other = (Servis) object;
        return (this.idService != null || other.idService == null) && (this.idService == null || this.idService.equals(other.idService));
    }

    @Override
    public String toString() {
        return "entity.Servis[ idService=" + idService + " ]";
    }
    
}
