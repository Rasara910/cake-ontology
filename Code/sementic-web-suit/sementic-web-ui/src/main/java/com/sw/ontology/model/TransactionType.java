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
@Table(name = "fgl_transaction_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionType.findAll", query = "SELECT t FROM TransactionType t"),
    @NamedQuery(name = "TransactionType.findByTransactionType", query = "SELECT t FROM TransactionType t WHERE t.transactionType = :transactionType"),
    @NamedQuery(name = "TransactionType.findByStatus", query = "SELECT t FROM TransactionType t WHERE t.status = :status"),
    @NamedQuery(name = "TransactionType.findByAddedBy", query = "SELECT t FROM TransactionType t WHERE t.addedBy = :addedBy"),
    @NamedQuery(name = "TransactionType.findByAddedDate", query = "SELECT t FROM TransactionType t WHERE t.addedDate = :addedDate"),
    @NamedQuery(name = "TransactionType.findByModifiedBy", query = "SELECT t FROM TransactionType t WHERE t.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "TransactionType.findByModifiedDate", query = "SELECT t FROM TransactionType t WHERE t.modifiedDate = :modifiedDate")})
public class TransactionType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "transaction_type")
    private String transactionType;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trxType")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;

    public TransactionType() {
    }

    public TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public TransactionType(String transactionType, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.transactionType = transactionType;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
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
    public List<MemberPointLedgerTrx> getMemberPointLedgerTrxList() {
        return memberPointLedgerTrxList;
    }

    public void setMemberPointLedgerTrxList(List<MemberPointLedgerTrx> memberPointLedgerTrxList) {
        this.memberPointLedgerTrxList = memberPointLedgerTrxList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (transactionType != null ? transactionType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionType)) {
            return false;
        }
        TransactionType other = (TransactionType) object;
        if ((this.transactionType == null && other.transactionType != null) || (this.transactionType != null && !this.transactionType.equals(other.transactionType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransactionType[ transactionType=" + transactionType + " ]";
    }
    
}
