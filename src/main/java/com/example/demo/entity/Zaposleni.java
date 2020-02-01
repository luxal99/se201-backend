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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThinkPad T480s
 */
@Entity
@Table(name = "zaposleni")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Zaposleni.findAll", query = "SELECT z FROM Zaposleni z")
    , @NamedQuery(name = "Zaposleni.findByIdEmployee", query = "SELECT z FROM Zaposleni z WHERE z.idEmployee = :idEmployee")
    , @NamedQuery(name = "Zaposleni.findByName", query = "SELECT z FROM Zaposleni z WHERE z.name = :name")
    , @NamedQuery(name = "Zaposleni.findByLastname", query = "SELECT z FROM Zaposleni z WHERE z.lastname = :lastname")})
public class Zaposleni implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_employee")
    private Integer idEmployee;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne
    private Korisnik idUser;

    public Zaposleni() {
    }

    public Zaposleni(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Zaposleni(Integer idEmployee, String name, String lastname) {
        this.idEmployee = idEmployee;
        this.name = name;
        this.lastname = lastname;
    }

    public Integer getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(Integer idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Korisnik getIdUser() {
        return idUser;
    }

    public void setIdUser(Korisnik idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEmployee != null ? idEmployee.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaposleni)) {
            return false;
        }
        Zaposleni other = (Zaposleni) object;
        return (this.idEmployee != null || other.idEmployee == null) && (this.idEmployee == null || this.idEmployee.equals(other.idEmployee));
    }

    @Override
    public String toString() {
        return "entity.Zaposleni[ idEmployee=" + idEmployee + " ]";
    }
    
}
