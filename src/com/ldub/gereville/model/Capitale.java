/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ldub.gereville.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lionel
 */
@Entity
@Table(name = "capitale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Capitale.findAll", query = "SELECT c FROM Capitale c")
    , @NamedQuery(name = "Capitale.findByVilleId", query = "SELECT c FROM Capitale c WHERE c.villeId = :villeId")
    , @NamedQuery(name = "Capitale.findByPresident", query = "SELECT c FROM Capitale c WHERE c.president = :president")})
public class Capitale implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ville_id")
    private Integer villeId;
    @Basic(optional = false)
    @Column(name = "president")
    private String president;
    @JoinColumn(name = "ville_id", referencedColumnName = "id", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Ville ville;

    public Capitale() {
    }

    public Capitale(Integer villeId) {
        this.villeId = villeId;
    }

    public Capitale(Integer villeId, String president) {
        this.villeId = villeId;
        this.president = president;
    }

    public Integer getVilleId() {
        return villeId;
    }

    public void setVilleId(Integer villeId) {
        this.villeId = villeId;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (villeId != null ? villeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Capitale)) {
            return false;
        }
        Capitale other = (Capitale) object;
        if ((this.villeId == null && other.villeId != null) || (this.villeId != null && !this.villeId.equals(other.villeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ldub.gerville.Capitale[ villeId=" + villeId + " ]";
    }
    
}
