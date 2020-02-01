/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "servis_ulja")
@JsonInclude
public class ServisUlja implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_oil_service")
    private Integer idOilService;
    @Column(name = "oil_type")
    private String oilType;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @OneToOne(cascade = {CascadeType.MERGE})
    @JsonBackReference
    private Servis idService;

    public ServisUlja() {
    }

    public ServisUlja(Integer idOilService) {
        this.idOilService = idOilService;
    }

    public Integer getIdOilService() {
        return idOilService;
    }

    public void setIdOilService(Integer idOilService) {
        this.idOilService = idOilService;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public Servis getIdService() {
        return idService;
    }

    public void setIdService(Servis idService) {
        this.idService = idService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOilService != null ? idOilService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServisUlja)) {
            return false;
        }
        ServisUlja other = (ServisUlja) object;
        return (this.idOilService != null || other.idOilService == null) && (this.idOilService == null || this.idOilService.equals(other.idOilService));
    }

    @Override
    public String toString() {
        return "entity.ServisUlja[ idOilService=" + idOilService + " ]";
    }
    
}
