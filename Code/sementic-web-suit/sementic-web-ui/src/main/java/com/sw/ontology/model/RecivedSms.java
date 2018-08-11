/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_recived_sms")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecivedSms.findAll", query = "SELECT r FROM RecivedSms r"),
    @NamedQuery(name = "RecivedSms.findById", query = "SELECT r FROM RecivedSms r WHERE r.id = :id"),
    @NamedQuery(name = "RecivedSms.findByMobileNo", query = "SELECT r FROM RecivedSms r WHERE r.mobileNo = :mobileNo"),
    @NamedQuery(name = "RecivedSms.findByReceivedTime", query = "SELECT r FROM RecivedSms r WHERE r.receivedTime = :receivedTime"),
    @NamedQuery(name = "RecivedSms.findByAddedBy", query = "SELECT r FROM RecivedSms r WHERE r.addedBy = :addedBy"),
    @NamedQuery(name = "RecivedSms.findByAddedDate", query = "SELECT r FROM RecivedSms r WHERE r.addedDate = :addedDate")})
public class RecivedSms implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic(optional = false)
    @Lob
    @Column(name = "message")
    private String message;
    @Basic(optional = false)
    @Column(name = "received_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receivedTime;
    @Basic(optional = false)
    @Column(name = "added_by")
    private String addedBy;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;

    public RecivedSms() {
    }

    public RecivedSms(Integer id) {
        this.id = id;
    }

    public RecivedSms(Integer id, String mobileNo, String message, Date receivedTime, String addedBy, Date addedDate) {
        this.id = id;
        this.mobileNo = mobileNo;
        this.message = message;
        this.receivedTime = receivedTime;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getReceivedTime() {
        return receivedTime;
    }

    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecivedSms)) {
            return false;
        }
        RecivedSms other = (RecivedSms) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RecivedSms[ id=" + id + " ]";
    }
    
}
