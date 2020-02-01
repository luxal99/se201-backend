/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "mehanicki_servis")
@JsonInclude
public class MehanickiServis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_mehanic_service")
    private Integer idMehanicService;
    @JoinColumn(name = "id_service", referencedColumnName = "id_service")
    @OneToOne(cascade = {CascadeType.MERGE})
    @JsonBackReference
    private Servis idService;
    @OneToMany(mappedBy = "idMehanicService")
    private List<Deo> deoList;

    public MehanickiServis() {
    }



    public MehanickiServis(Integer idMehanicService) {
        this.idMehanicService = idMehanicService;
    }

    public Integer getIdMehanicService() {
        return idMehanicService;
    }

    public void setIdMehanicService(Integer idMehanicService) {
        this.idMehanicService = idMehanicService;
    }

    public Servis getIdService() {
        return idService;
    }

    public void setIdService(Servis idService) {
        this.idService = idService;
    }

    @XmlTransient
    public List<Deo> getDeoList() {
        return deoList;
    }

    public void setDeoList(List<Deo> deoList) {
        this.deoList = deoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMehanicService != null ? idMehanicService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MehanickiServis)) {
            return false;
        }
        MehanickiServis other = (MehanickiServis) object;
        return (this.idMehanicService != null || other.idMehanicService == null) && (this.idMehanicService == null || this.idMehanicService.equals(other.idMehanicService));
    }

    @Override
    public String toString() {
        return "entity.MehanickiServis[ idMehanicService=" + idMehanicService + " ]";
    }
    
}
