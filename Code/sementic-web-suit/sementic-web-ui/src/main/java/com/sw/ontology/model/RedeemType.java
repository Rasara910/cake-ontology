/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_redeem_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeemType.findAll", query = "SELECT r FROM RedeemType r"),
    @NamedQuery(name = "RedeemType.findByRedemptionType", query = "SELECT r FROM RedeemType r WHERE r.redemptionType = :redemptionType"),
    @NamedQuery(name = "RedeemType.findByStatus", query = "SELECT r FROM RedeemType r WHERE r.status = :status"),
    @NamedQuery(name = "RedeemType.findByAddedBy", query = "SELECT r FROM RedeemType r WHERE r.addedBy = :addedBy"),
    @NamedQuery(name = "RedeemType.findByAddedDate", query = "SELECT r FROM RedeemType r WHERE r.addedDate = :addedDate"),
    @NamedQuery(name = "RedeemType.findByModifiedBy", query = "SELECT r FROM RedeemType r WHERE r.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "RedeemType.findByModifiedDate", query = "SELECT r FROM RedeemType r WHERE r.modifiedDate = :modifiedDate")})
public class RedeemType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "redemption_type")
    private String redemptionType;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "added_by")
    private String addedBy;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "modified_by")
    private String modifiedBy;
    @Basic(optional = false)
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redemptionType")
    private List<RedeemDetails> redeemDetailsList;

    public RedeemType() {
    }

    public RedeemType(String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public RedeemType(String redemptionType, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.redemptionType = redemptionType;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(String redemptionType) {
        this.redemptionType = redemptionType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @XmlTransient
    public List<RedeemDetails> getRedeemDetailsList() {
        return redeemDetailsList;
    }

    public void setRedeemDetailsList(List<RedeemDetails> redeemDetailsList) {
        this.redeemDetailsList = redeemDetailsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redemptionType != null ? redemptionType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeemType)) {
            return false;
        }
        RedeemType other = (RedeemType) object;
        if ((this.redemptionType == null && other.redemptionType != null) || (this.redemptionType != null && !this.redemptionType.equals(other.redemptionType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedeemType[ redemptionType=" + redemptionType + " ]";
    }
    
}
