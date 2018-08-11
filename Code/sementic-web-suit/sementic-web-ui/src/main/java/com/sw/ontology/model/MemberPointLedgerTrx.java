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
@Table(name = "fgl_member_point_ledger_trx")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberPointLedgerTrx.findAll", query = "SELECT m FROM MemberPointLedgerTrx m"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByTrxId", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.trxId = :trxId"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByTrxDate", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.trxDate = :trxDate"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByValue", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.value = :value"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByStatus", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.status = :status"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByAddedBy", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.addedBy = :addedBy"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByAddedDate", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.addedDate = :addedDate"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByModifiedBy", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "MemberPointLedgerTrx.findByModifiedDate", query = "SELECT m FROM MemberPointLedgerTrx m WHERE m.modifiedDate = :modifiedDate")})
public class MemberPointLedgerTrx implements Serializable {
    @JoinColumn(name = "redemption_reference_id", referencedColumnName = "redemption_reference_id")
    @ManyToOne
    private RedeemDetails redemptionReferenceId;
    @JoinColumn(name = "sale_id", referencedColumnName = "sale_id")
    @ManyToOne
    private RclSale saleId;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "trx_id")
    private Integer trxId;
    @Basic(optional = false)
    @Column(name = "trx_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trxDate;
    @Basic(optional = false)
    @Column(name = "value")
    private double value;
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
    @JoinColumn(name = "rule_id", referencedColumnName = "rule_id")
    @ManyToOne
    private ProgramRule ruleId;
    @JoinColumn(name = "member_code", referencedColumnName = "member_code")
    @ManyToOne(optional = false)
    private MemberMaster memberCode;
    @JoinColumn(name = "trx_type", referencedColumnName = "transaction_type")
    @ManyToOne(optional = false)
    private TransactionType trxType;
    @JoinColumn(name = "trx_category", referencedColumnName = "category_name")
    @ManyToOne(optional = false)
    private TransactionCategory trxCategory;

    public MemberPointLedgerTrx() {
    }

    public MemberPointLedgerTrx(Integer trxId) {
        this.trxId = trxId;
    }

    public MemberPointLedgerTrx(Integer trxId, Date trxDate, double value, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.trxId = trxId;
        this.trxDate = trxDate;
        this.value = value;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Integer getTrxId() {
        return trxId;
    }

    public void setTrxId(Integer trxId) {
        this.trxId = trxId;
    }

    public Date getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Date trxDate) {
        this.trxDate = trxDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
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

    public ProgramRule getRuleId() {
        return ruleId;
    }

    public void setRuleId(ProgramRule ruleId) {
        this.ruleId = ruleId;
    }

    public MemberMaster getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(MemberMaster memberCode) {
        this.memberCode = memberCode;
    }

    public TransactionType getTrxType() {
        return trxType;
    }

    public void setTrxType(TransactionType trxType) {
        this.trxType = trxType;
    }

    public TransactionCategory getTrxCategory() {
        return trxCategory;
    }

    public void setTrxCategory(TransactionCategory trxCategory) {
        this.trxCategory = trxCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (trxId != null ? trxId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberPointLedgerTrx)) {
            return false;
        }
        MemberPointLedgerTrx other = (MemberPointLedgerTrx) object;
        if ((this.trxId == null && other.trxId != null) || (this.trxId != null && !this.trxId.equals(other.trxId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MemberPointLedgerTrx[ trxId=" + trxId + " ]";
    }

    public RedeemDetails getRedemptionReferenceId() {
        return redemptionReferenceId;
    }

    public void setRedemptionReferenceId(RedeemDetails redemptionReferenceId) {
        this.redemptionReferenceId = redemptionReferenceId;
    }

    public RclSale getSaleId() {
        return saleId;
    }

    public void setSaleId(RclSale saleId) {
        this.saleId = saleId;
    }
    
}
