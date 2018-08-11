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
@Table(name = "fgl_program_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramRule.findAll", query = "SELECT p FROM ProgramRule p"),
    @NamedQuery(name = "ProgramRule.findByRuleId", query = "SELECT p FROM ProgramRule p WHERE p.ruleId = :ruleId"),
    @NamedQuery(name = "ProgramRule.findByPercentage", query = "SELECT p FROM ProgramRule p WHERE p.percentage = :percentage")})
public class ProgramRule implements Serializable {
    @OneToMany(mappedBy = "ruleId")
    private List<RclSale> rclSaleList;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date")
    @Temporal(TemporalType.DATE)
    private Date endDate;
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
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rule_id")
    private Integer ruleId;
    @Basic(optional = false)
    @Column(name = "percentage")
    private double percentage;
    @JoinColumn(name = "product_type", referencedColumnName = "product_type")
    @ManyToOne
    private ProductType productType;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private LoyaltyProgram programId;
    @JoinColumn(name = "member_class", referencedColumnName = "member_class")
    @ManyToOne
    private MemberClass memberClass;
    @JoinColumn(name = "member_type", referencedColumnName = "member_type")
    @ManyToOne
    private MemberType memberType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ruleId")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;

    public ProgramRule() {
    }

    public ProgramRule(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public ProgramRule(Integer ruleId, double percentage) {
        this.ruleId = ruleId;
        this.percentage = percentage;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public LoyaltyProgram getProgramId() {
        return programId;
    }

    public void setProgramId(LoyaltyProgram programId) {
        this.programId = programId;
    }

    public MemberClass getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(MemberClass memberClass) {
        this.memberClass = memberClass;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
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
        hash += (ruleId != null ? ruleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramRule)) {
            return false;
        }
        ProgramRule other = (ProgramRule) object;
        if ((this.ruleId == null && other.ruleId != null) || (this.ruleId != null && !this.ruleId.equals(other.ruleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramRule[ ruleId=" + ruleId + " ]";
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
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
    public List<RclSale> getRclSaleList() {
        return rclSaleList;
    }

    public void setRclSaleList(List<RclSale> rclSaleList) {
        this.rclSaleList = rclSaleList;
    }
    
}
