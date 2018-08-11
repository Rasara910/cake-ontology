/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_salutation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salutation.findAll", query = "SELECT s FROM Salutation s"),
    @NamedQuery(name = "Salutation.findBySalutation", query = "SELECT s FROM Salutation s WHERE s.salutation = :salutation"),
    @NamedQuery(name = "Salutation.findByStatus", query = "SELECT s FROM Salutation s WHERE s.status = :status")})
public class Salutation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "salutation")
    private String salutation;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "salutation")
    private List<MemberMaster> memberMasterList;

    public Salutation() {
    }

    public Salutation(String salutation) {
        this.salutation = salutation;
    }

    public Salutation(String salutation, String status) {
        this.salutation = salutation;
        this.status = status;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlTransient
    public List<MemberMaster> getMemberMasterList() {
        return memberMasterList;
    }

    public void setMemberMasterList(List<MemberMaster> memberMasterList) {
        this.memberMasterList = memberMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salutation != null ? salutation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salutation)) {
            return false;
        }
        Salutation other = (Salutation) object;
        if ((this.salutation == null && other.salutation != null) || (this.salutation != null && !this.salutation.equals(other.salutation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Salutation[ salutation=" + salutation + " ]";
    }
    
}
