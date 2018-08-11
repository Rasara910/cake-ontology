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
import javax.persistence.Lob;
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
@Table(name = "fgl_sms_log")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmsLog.findAll", query = "SELECT s FROM SmsLog s"),
    @NamedQuery(name = "SmsLog.findBySmsType", query = "SELECT s FROM SmsLog s WHERE s.smsType = :smsType"),
    @NamedQuery(name = "SmsLog.findByMobileNo", query = "SELECT s FROM SmsLog s WHERE s.mobileNo = :mobileNo"),
    @NamedQuery(name = "SmsLog.findByStatus", query = "SELECT s FROM SmsLog s WHERE s.status = :status"),
    @NamedQuery(name = "SmsLog.findByAddedBy", query = "SELECT s FROM SmsLog s WHERE s.addedBy = :addedBy"),
    @NamedQuery(name = "SmsLog.findByAddedDate", query = "SELECT s FROM SmsLog s WHERE s.addedDate = :addedDate"),
    @NamedQuery(name = "SmsLog.findByModifiedBy", query = "SELECT s FROM SmsLog s WHERE s.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "SmsLog.findByModifiedDate", query = "SELECT s FROM SmsLog s WHERE s.modifiedDate = :modifiedDate")})
public class SmsLog implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sms_reference_id")
    private Integer smsReferenceId;
    @Basic(optional = false)
    @Column(name = "sms_type")
    private String smsType;
    @Basic(optional = false)
    @Column(name = "mobile_no")
    private String mobileNo;
    @Basic(optional = false)
    @Lob
    @Column(name = "sms_text")
    private String smsText;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Lob
    @Column(name = "response_code")
    private String responseCode;
    @Basic(optional = false)
    @Column(name = "added_by")
    private String addedBy;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @JoinColumn(name = "member_code", referencedColumnName = "member_code")
    @ManyToOne(optional = false)
    private MemberMaster memberCode;

    public SmsLog() {
    }

    public SmsLog(Integer smsReferenceId) {
        this.smsReferenceId = smsReferenceId;
    }

    public SmsLog(Integer smsReferenceId, String smsType, String mobileNo, String smsText, String status, String addedBy, Date addedDate) {
        this.smsReferenceId = smsReferenceId;
        this.smsType = smsType;
        this.mobileNo = mobileNo;
        this.smsText = smsText;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
    }

    public Integer getSmsReferenceId() {
        return smsReferenceId;
    }

    public void setSmsReferenceId(Integer smsReferenceId) {
        this.smsReferenceId = smsReferenceId;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }


    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
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

    public MemberMaster getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(MemberMaster memberCode) {
        this.memberCode = memberCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (smsReferenceId != null ? smsReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmsLog)) {
            return false;
        }
        SmsLog other = (SmsLog) object;
        if ((this.smsReferenceId == null && other.smsReferenceId != null) || (this.smsReferenceId != null && !this.smsReferenceId.equals(other.smsReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "SmsLog[ smsReferenceId=" + smsReferenceId + " ]";
    }
    
}
