/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldub.gerville;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lionel
 */
@Entity
@Table(name = "ville")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v")
    , @NamedQuery(name = "Ville.findById", query = "SELECT v FROM Ville v WHERE v.id = :id")
    , @NamedQuery(name = "Ville.findByNom", query = "SELECT v FROM Ville v WHERE v.nom = :nom")
    , @NamedQuery(name = "Ville.findByNbhabitants", query = "SELECT v FROM Ville v WHERE v.nbhabitants = :nbhabitants")})
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @Column(name = "nbhabitants")
    private int nbhabitants;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ville")
    private Capitale capitale;
    @JoinColumn(name = "pays_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pays paysId;
    @OneToMany(mappedBy = "capitaleId")
    private List<Pays> paysList;

    public Ville() {
    }

    public Ville(Integer id) {
        this.id = id;
    }

    public Ville(Integer id, String nom, int nbhabitants) {
        this.id = id;
        this.nom = nom;
        this.nbhabitants = nbhabitants;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbhabitants() {
        return nbhabitants;
    }

    public void setNbhabitants(int nbhabitants) {
        this.nbhabitants = nbhabitants;
    }

    public Capitale getCapitale() {
        return capitale;
    }

    public void setCapitale(Capitale capitale) {
        this.capitale = capitale;
    }

    public Pays getPaysId() {
        return paysId;
    }

    public void setPaysId(Pays paysId) {
        this.paysId = paysId;
    }

    @XmlTransient
    public List<Pays> getPaysList() {
        return paysList;
    }

    public void setPaysList(List<Pays> paysList) {
        this.paysList = paysList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ldub.gerville.Ville[ id=" + id + " ]";
    }
    
}
