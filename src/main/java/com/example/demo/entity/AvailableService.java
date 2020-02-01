/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "available_service")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AvailableService.findAll", query = "SELECT a FROM AvailableService a")
    , @NamedQuery(name = "AvailableService.findByIdAvailableService", query = "SELECT a FROM AvailableService a WHERE a.idAvailableService = :idAvailableService")
    , @NamedQuery(name = "AvailableService.findByDate", query = "SELECT a FROM AvailableService a WHERE a.date = :date")
    , @NamedQuery(name = "AvailableService.findByTime", query = "SELECT a FROM AvailableService a WHERE a.time = :time")})
public class AvailableService implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_available_service")
    private Integer idAvailableService;
    @Basic(optional = false)
    @Column(name = "date")
    private String date;
    @Basic(optional = false)
    @Column(name = "time")
    private String time;

    public AvailableService() {
    }

    public AvailableService(Integer idAvailableService) {
        this.idAvailableService = idAvailableService;
    }

    public AvailableService(Integer idAvailableService, String date, String time) {
        this.idAvailableService = idAvailableService;
        this.date = date;
        this.time = time;
    }

    public Integer getIdAvailableService() {
        return idAvailableService;
    }

    public void setIdAvailableService(Integer idAvailableService) {
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
    public int hashCode() {
        int hash = 0;
        hash += (idAvailableService != null ? idAvailableService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AvailableService)) {
            return false;
        }
        AvailableService other = (AvailableService) object;
        return (this.idAvailableService != null || other.idAvailableService == null) && (this.idAvailableService == null || this.idAvailableService.equals(other.idAvailableService));
    }

    @Override
    public String toString() {
        return "entity.AvailableService[ idAvailableService=" + idAvailableService + " ]";
    }
    
}
