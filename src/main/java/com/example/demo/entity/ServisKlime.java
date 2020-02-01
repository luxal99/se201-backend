/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "servis_klime")
@JsonInclude
public class ServisKlime implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ac_service")
    private Integer idAcService;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "gas_amount")
    private BigDecimal gasAmount;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @OneToOne(cascade = {CascadeType.MERGE})
    @JsonBackReference
    private Servis idService;

    public ServisKlime() {
    }

    public ServisKlime(Integer idAcService) {
        this.idAcService = idAcService;
    }

    public Integer getIdAcService() {
        return idAcService;
    }

    public void setIdAcService(Integer idAcService) {
        this.idAcService = idAcService;
    }

    public BigDecimal getGasAmount() {
        return gasAmount;
    }

    public void setGasAmount(BigDecimal gasAmount) {
        this.gasAmount = gasAmount;
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
        hash += (idAcService != null ? idAcService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServisKlime)) {
            return false;
        }
        ServisKlime other = (ServisKlime) object;
        return (this.idAcService != null || other.idAcService == null) && (this.idAcService == null || this.idAcService.equals(other.idAcService));
    }

    @Override
    public String toString() {
        return "entity.ServisKlime[ idAcService=" + idAcService + " ]";
    }
    
}
