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
@Table(name = "fgl_showroom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Showroom.findAll", query = "SELECT s FROM Showroom s"),
    @NamedQuery(name = "Showroom.findByShowroomName", query = "SELECT s FROM Showroom s WHERE s.showroomName = :showroomName"),
    @NamedQuery(name = "Showroom.findByShowroomCode", query = "SELECT s FROM Showroom s WHERE s.showroomCode = :showroomCode"),
    @NamedQuery(name = "Showroom.findByStatus", query = "SELECT s FROM Showroom s WHERE s.status = :status"),
    @NamedQuery(name = "Showroom.findByAddedBy", query = "SELECT s FROM Showroom s WHERE s.addedBy = :addedBy"),
    @NamedQuery(name = "Showroom.findByAddedDate", query = "SELECT s FROM Showroom s WHERE s.addedDate = :addedDate"),
    @NamedQuery(name = "Showroom.findByModifiedBy", query = "SELECT s FROM Showroom s WHERE s.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Showroom.findByModifiedDate", query = "SELECT s FROM Showroom s WHERE s.modifiedDate = :modifiedDate")})
public class Showroom implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "showroom_name")
    private String showroomName;
    @Basic(optional = false)
    @Column(name = "showroom_code")
    private String showroomCode;
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
    @OneToMany(mappedBy = "showroomName")
    private List<User> userList;
    @OneToMany(mappedBy = "collectionShowroomName")
    private List<RedeemDetails> redeemDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "requestedFromShowroom")
    private List<RedeemDetails> redeemDetailsList1;

    public Showroom() {
    }

    public Showroom(String showroomName) {
        this.showroomName = showroomName;
    }

    public Showroom(String showroomName, String showroomCode, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.showroomName = showroomName;
        this.showroomCode = showroomCode;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getShowroomName() {
        return showroomName;
    }

    public void setShowroomName(String showroomName) {
        this.showroomName = showroomName;
    }

    public String getShowroomCode() {
        return showroomCode;
    }

    public void setShowroomCode(String showroomCode) {
        this.showroomCode = showroomCode;
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
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<RedeemDetails> getRedeemDetailsList() {
        return redeemDetailsList;
    }

    public void setRedeemDetailsList(List<RedeemDetails> redeemDetailsList) {
        this.redeemDetailsList = redeemDetailsList;
    }

    @XmlTransient
    public List<RedeemDetails> getRedeemDetailsList1() {
        return redeemDetailsList1;
    }

    public void setRedeemDetailsList1(List<RedeemDetails> redeemDetailsList1) {
        this.redeemDetailsList1 = redeemDetailsList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (showroomName != null ? showroomName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Showroom)) {
            return false;
        }
        Showroom other = (Showroom) object;
        if ((this.showroomName == null && other.showroomName != null) || (this.showroomName != null && !this.showroomName.equals(other.showroomName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Showroom[ showroomName=" + showroomName + " ]";
    }
    
}
