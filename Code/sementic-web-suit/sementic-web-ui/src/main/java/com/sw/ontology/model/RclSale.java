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
@Table(name = "fgl_rcl_sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RclSale.findAll", query = "SELECT r FROM RclSale r"),
    @NamedQuery(name = "RclSale.findBySaleId", query = "SELECT r FROM RclSale r WHERE r.saleId = :saleId"),
    @NamedQuery(name = "RclSale.findByInvoiceNo", query = "SELECT r FROM RclSale r WHERE r.invoiceNo = :invoiceNo"),
    @NamedQuery(name = "RclSale.findByInvoiceDate", query = "SELECT r FROM RclSale r WHERE r.invoiceDate = :invoiceDate"),
    @NamedQuery(name = "RclSale.findByInvoiceAmount", query = "SELECT r FROM RclSale r WHERE r.invoiceAmount = :invoiceAmount")})
public class RclSale implements Serializable {
    @JoinColumn(name = "rule_id", referencedColumnName = "rule_id")
    @ManyToOne
    private ProgramRule ruleId;
    @Column(name = "showroom")
    private String showroom;
    @Basic(optional = false)
    @Column(name = "serial_no")
    private int serialNo;
    @Basic(optional = false)
    @Column(name = "customer_trx_no")
    private int customerTrxNo;
    @Basic(optional = false)
    @Column(name = "coupon_no")
    private String couponNo;
    @OneToMany(mappedBy = "saleId")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;
    @Column(name = "product_type")
    private String productType;
    @JoinColumn(name = "member_code", referencedColumnName = "member_code")
    @ManyToOne(optional = false)
    private MemberMaster memberCode;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sale_id")
    private Integer saleId;
    @Basic(optional = false)
    @Column(name = "invoice_no")
    private String invoiceNo;
    @Basic(optional = false)
    @Column(name = "invoice_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Basic(optional = false)
    @Column(name = "invoice_amount")
    private double invoiceAmount;
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

    public RclSale() {
    }

    public RclSale(Integer saleId) {
        this.saleId = saleId;
    }

    public RclSale(Integer saleId, String invoiceNo, Date invoiceDate, double invoiceAmount) {
        this.saleId = saleId;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
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
    
    

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RclSale)) {
            return false;
        }
        RclSale other = (RclSale) object;
        if ((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RclSale[ saleId=" + saleId + " ]";
    }

    public MemberMaster getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(MemberMaster memberCode) {
        this.memberCode = memberCode;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @XmlTransient
    public List<MemberPointLedgerTrx> getMemberPointLedgerTrxList() {
        return memberPointLedgerTrxList;
    }

    public void setMemberPointLedgerTrxList(List<MemberPointLedgerTrx> memberPointLedgerTrxList) {
        this.memberPointLedgerTrxList = memberPointLedgerTrxList;
    }

    public int getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    public int getCustomerTrxNo() {
        return customerTrxNo;
    }

    public void setCustomerTrxNo(int customerTrxNo) {
        this.customerTrxNo = customerTrxNo;
    }

    public String getCouponNo() {
        return couponNo;
    }

    public void setCouponNo(String couponNo) {
        this.couponNo = couponNo;
    }

    public String getShowroom() {
        return showroom;
    }

    public void setShowroom(String showroom) {
        this.showroom = showroom;
    }

    public ProgramRule getRuleId() {
        return ruleId;
    }

    public void setRuleId(ProgramRule ruleId) {
        this.ruleId = ruleId;
    }
    
}
