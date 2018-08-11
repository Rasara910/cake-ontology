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
@Table(name = "fgl_transaction_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TransactionCategory.findAll", query = "SELECT t FROM TransactionCategory t"),
    @NamedQuery(name = "TransactionCategory.findByCategoryName", query = "SELECT t FROM TransactionCategory t WHERE t.categoryName = :categoryName"),
    @NamedQuery(name = "TransactionCategory.findByCreditDebit", query = "SELECT t FROM TransactionCategory t WHERE t.creditDebit = :creditDebit"),
    @NamedQuery(name = "TransactionCategory.findByStatus", query = "SELECT t FROM TransactionCategory t WHERE t.status = :status"),
    @NamedQuery(name = "TransactionCategory.findByAddedBy", query = "SELECT t FROM TransactionCategory t WHERE t.addedBy = :addedBy"),
    @NamedQuery(name = "TransactionCategory.findByAddedDate", query = "SELECT t FROM TransactionCategory t WHERE t.addedDate = :addedDate"),
    @NamedQuery(name = "TransactionCategory.findByModifiedBy", query = "SELECT t FROM TransactionCategory t WHERE t.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "TransactionCategory.findByModifiedDate", query = "SELECT t FROM TransactionCategory t WHERE t.modifiedDate = :modifiedDate")})
public class TransactionCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "category_name")
    private String categoryName;
    @Basic(optional = false)
    @Column(name = "credit_debit")
    private String creditDebit;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "added_by")
    private String addedBy;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trxCategory")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;

    public TransactionCategory() {
    }

    public TransactionCategory(String categoryName) {
        this.categoryName = categoryName;
    }

    public TransactionCategory(String categoryName, String creditDebit, String status, String addedBy, String modifiedBy, Date modifiedDate) {
        this.categoryName = categoryName;
        this.creditDebit = creditDebit;
        this.status = status;
        this.addedBy = addedBy;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreditDebit() {
        return creditDebit;
    }

    public void setCreditDebit(String creditDebit) {
        this.creditDebit = creditDebit;
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
        hash += (categoryName != null ? categoryName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TransactionCategory)) {
            return false;
        }
        TransactionCategory other = (TransactionCategory) object;
        if ((this.categoryName == null && other.categoryName != null) || (this.categoryName != null && !this.categoryName.equals(other.categoryName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TransactionCategory[ categoryName=" + categoryName + " ]";
    }
    
}
