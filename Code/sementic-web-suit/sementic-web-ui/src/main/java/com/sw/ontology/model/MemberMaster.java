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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "fgl_member")
@XmlRootElement
public class MemberMaster implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberCode")
    private List<RclSale> rclSaleList;
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "member_code")
    private String memberCode;
    @Basic(optional = false)
    @Column(name = "nic")
    private String nic;
    @Basic(optional = false)
    @Column(name = "member_since")
    @Temporal(TemporalType.DATE)
    private Date memberSince;
    @Basic(optional = false)
    @Column(name = "name_1")
    private String name1;
    @Basic(optional = false)
    @Column(name = "name_2")
    private String name2;
    @Column(name = "name_3")
    private String name3;
    @Column(name = "contact_address_1")
    private String contactAddress1;
    @Column(name = "contact_address_2")
    private String contactAddress2;
    @Column(name = "contact_address_3")
    private String contactAddress3;
    @Column(name = "contact_phone_1")
    private String contactPhone1;
    @Column(name = "phone_2")
    private String phone2;
    @Column(name = "contact_mobile_1")
    private String contactMobile1;
    @Column(name = "mobile_2")
    private String mobile2;
    @Column(name = "email_1")
    private String email1;
    @Column(name = "email_2")
    private String email2;
    @Column(name = "member_status")
    private String memberStatus;
    @Column(name = "passport_no")
    private String passportNo;
    @Column(name = "driving_license")
    private String drivingLicense;
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "acct_name")
    private String accountName;
    @Column(name = "acct_no")
    private String accountNo;
    @Column(name = "bank_name")
    private String bankName;
    @Column(name = "branch_name")
    private String branchName;
    @Column(name = "fax")
    private String fax;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberCode")
    private List<RedeemDetails> redeemDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberCode")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberCode")
    private List<SmsLog> smsLogList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "memberMaster")
    private MemberPointLedger memberPointLedger;
    @JoinColumn(name = "member_type", referencedColumnName = "member_type")
    @ManyToOne(optional = false)
    private MemberType memberType;
    @JoinColumn(name = "member_class", referencedColumnName = "member_class")
    @ManyToOne
    private MemberClass memberClass;
    @JoinColumn(name = "salutation", referencedColumnName = "salutation")
    @ManyToOne(optional = false)
    private Salutation salutation;

    public MemberMaster() {
    }

    public MemberMaster(String memberCode) {
        this.memberCode = memberCode;
    }

    public MemberMaster(String memberCode, String nic, Date memberSince, String name1, String name2, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.memberCode = memberCode;
        this.nic = nic;
        this.memberSince = memberSince;
        this.name1 = name1;
        this.name2 = name2;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(Date memberSince) {
        this.memberSince = memberSince;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getName3() {
        return name3;
    }

    public void setName3(String name3) {
        this.name3 = name3;
    }

    public String getContactAddress1() {
        return contactAddress1;
    }

    public void setContactAddress1(String contactAddress1) {
        this.contactAddress1 = contactAddress1;
    }

    public String getContactAddress2() {
        return contactAddress2;
    }

    public void setContactAddress2(String contactAddress2) {
        this.contactAddress2 = contactAddress2;
    }

    public String getContactAddress3() {
        return contactAddress3;
    }

    public void setContactAddress3(String contactAddress3) {
        this.contactAddress3 = contactAddress3;
    }

    public String getContactPhone1() {
        return contactPhone1;
    }

    public void setContactPhone1(String contactPhone1) {
        this.contactPhone1 = contactPhone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getContactMobile1() {
        return contactMobile1;
    }

    public void setContactMobile1(String contactMobile1) {
        this.contactMobile1 = contactMobile1;
    }

    public String getMobile2() {
        return mobile2;
    }

    public void setMobile2(String mobile2) {
        this.mobile2 = mobile2;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public String getDrivingLicense() {
        return drivingLicense;
    }

    public void setDrivingLicense(String drivingLicense) {
        this.drivingLicense = drivingLicense;
    }

    public String getMemberStatus() {
        return memberStatus;
    }

    public void setMemberStatus(String memberStatus) {
        this.memberStatus = memberStatus;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
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

    @XmlTransient
    public List<MemberPointLedgerTrx> getMemberPointLedgerTrxList() {
        return memberPointLedgerTrxList;
    }

    public void setMemberPointLedgerTrxList(List<MemberPointLedgerTrx> memberPointLedgerTrxList) {
        this.memberPointLedgerTrxList = memberPointLedgerTrxList;
    }

    @XmlTransient
    public List<SmsLog> getSmsLogList() {
        return smsLogList;
    }

    public void setSmsLogList(List<SmsLog> smsLogList) {
        this.smsLogList = smsLogList;
    }

    public MemberPointLedger getMemberPointLedger() {
        return memberPointLedger;
    }

    public void setMemberPointLedger(MemberPointLedger memberPointLedger) {
        this.memberPointLedger = memberPointLedger;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public MemberClass getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(MemberClass memberClass) {
        this.memberClass = memberClass;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberCode != null ? memberCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberMaster)) {
            return false;
        }
        MemberMaster other = (MemberMaster) object;
        if ((this.memberCode == null && other.memberCode != null) || (this.memberCode != null && !this.memberCode.equals(other.memberCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MemberMaster[ memberCode=" + memberCode + " ]";
    }

    @XmlTransient
    public List<RclSale> getRclSaleList() {
        return rclSaleList;
    }

    public void setRclSaleList(List<RclSale> rclSaleList) {
        this.rclSaleList = rclSaleList;
    }
    
}
