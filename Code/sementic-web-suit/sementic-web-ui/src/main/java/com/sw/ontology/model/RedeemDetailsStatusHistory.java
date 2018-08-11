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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "fgl_redeem_details_st_his")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeemDetailsStHis.findAll", query = "SELECT r FROM RedeemDetailsStatusHistory r"),
    @NamedQuery(name = "RedeemDetailsStHis.findByHistoryId", query = "SELECT r FROM RedeemDetailsStatusHistory r WHERE r.historyId = :historyId"),
    @NamedQuery(name = "RedeemDetailsStHis.findByStatus", query = "SELECT r FROM RedeemDetailsStatusHistory r WHERE r.status = :status"),
    @NamedQuery(name = "RedeemDetailsStHis.findByChangedDate", query = "SELECT r FROM RedeemDetailsStatusHistory r WHERE r.changedDate = :changedDate"),
    @NamedQuery(name = "RedeemDetailsStHis.findByChangedBy", query = "SELECT r FROM RedeemDetailsStatusHistory r WHERE r.changedBy = :changedBy")})
public class RedeemDetailsStatusHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "history_id")
    private Integer historyId;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "changed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date changedDate;
    @Basic(optional = false)
    @Column(name = "changed_by")
    private String changedBy;
    @JoinColumn(name = "redemption_reference_id", referencedColumnName = "redemption_reference_id")
    @ManyToOne(optional = false)
    private RedeemDetails redemptionReferenceId;

    public RedeemDetailsStatusHistory() {
    }

    public RedeemDetailsStatusHistory(Integer historyId) {
        this.historyId = historyId;
    }

    public RedeemDetailsStatusHistory(Integer historyId, String status, Date changedDate, String changedBy) {
        this.historyId = historyId;
        this.status = status;
        this.changedDate = changedDate;
        this.changedBy = changedBy;
    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Date changedDate) {
        this.changedDate = changedDate;
    }

    public String getChangedBy() {
        return changedBy;
    }

    public void setChangedBy(String changedBy) {
        this.changedBy = changedBy;
    }

    public RedeemDetails getRedemptionReferenceId() {
        return redemptionReferenceId;
    }

    public void setRedemptionReferenceId(RedeemDetails redemptionReferenceId) {
        this.redemptionReferenceId = redemptionReferenceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (historyId != null ? historyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeemDetailsStatusHistory)) {
            return false;
        }
        RedeemDetailsStatusHistory other = (RedeemDetailsStatusHistory) object;
        if ((this.historyId == null && other.historyId != null) || (this.historyId != null && !this.historyId.equals(other.historyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.fg.loyalty.model.RedeemDetailsStHis[ historyId=" + historyId + " ]";
    }
    
}
