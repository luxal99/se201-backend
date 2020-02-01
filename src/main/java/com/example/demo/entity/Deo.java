/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "deo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deo.findAll", query = "SELECT d FROM Deo d")
    , @NamedQuery(name = "Deo.findByIdReplacementPart", query = "SELECT d FROM Deo d WHERE d.idReplacementPart = :idReplacementPart")
    , @NamedQuery(name = "Deo.findByBrend", query = "SELECT d FROM Deo d WHERE d.brend = :brend")
    , @NamedQuery(name = "Deo.findByBrendCode", query = "SELECT d FROM Deo d WHERE d.brendCode = :brendCode")
    , @NamedQuery(name = "Deo.findByPrice", query = "SELECT d FROM Deo d WHERE d.price = :price")
    , @NamedQuery(name = "Deo.findByAmount", query = "SELECT d FROM Deo d WHERE d.amount = :amount")
    , @NamedQuery(name = "Deo.findByType", query = "SELECT d FROM Deo d WHERE d.type = :type")})
public class Deo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_replacement_part")
    private Integer idReplacementPart;
    @Basic(optional = false)
    @Column(name = "brend")
    private String brend;
    @Basic(optional = false)
    @Column(name = "brend_code")
    private String brendCode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @JoinColumn(name = "id_mehanic_service", referencedColumnName = "id_mehanic_service")
    @ManyToOne
    private MehanickiServis idMehanicService;

    public Deo() {
    }

    public Deo(Integer idReplacementPart) {
        this.idReplacementPart = idReplacementPart;
    }

    public Deo(Integer idReplacementPart, String brend, String brendCode, BigDecimal price, int amount, String type) {
        this.idReplacementPart = idReplacementPart;
        this.brend = brend;
        this.brendCode = brendCode;
        this.price = price;
        this.amount = amount;
        this.type = type;
    }

    public Integer getIdReplacementPart() {
        return idReplacementPart;
    }

    public void setIdReplacementPart(Integer idReplacementPart) {
        this.idReplacementPart = idReplacementPart;
    }

    public String getBrend() {
        return brend;
    }

    public void setBrend(String brend) {
        this.brend = brend;
    }

    public String getBrendCode() {
        return brendCode;
    }

    public void setBrendCode(String brendCode) {
        this.brendCode = brendCode;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MehanickiServis getIdMehanicService() {
        return idMehanicService;
    }

    public void setIdMehanicService(MehanickiServis idMehanicService) {
        this.idMehanicService = idMehanicService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReplacementPart != null ? idReplacementPart.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Deo)) {
            return false;
        }
        Deo other = (Deo) object;
        return (this.idReplacementPart != null || other.idReplacementPart == null) && (this.idReplacementPart == null || this.idReplacementPart.equals(other.idReplacementPart));
    }

    @Override
    public String toString() {
        return "entity.Deo[ idReplacementPart=" + idReplacementPart + " ]";
    }
    
}
