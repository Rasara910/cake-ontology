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
@Table(name = "fgl_redeem_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedeemDetails.findAll", query = "SELECT r FROM RedeemDetails r"),
    @NamedQuery(name = "RedeemDetails.findByRedemptionReferenceId", query = "SELECT r FROM RedeemDetails r WHERE r.redemptionReferenceId = :redemptionReferenceId"),
    @NamedQuery(name = "RedeemDetails.findByRedemptionRequestedDate", query = "SELECT r FROM RedeemDetails r WHERE r.redemptionRequestedDate = :redemptionRequestedDate"),
    @NamedQuery(name = "RedeemDetails.findByCollectionPoint", query = "SELECT r FROM RedeemDetails r WHERE r.collectionPoint = :collectionPoint"),
    @NamedQuery(name = "RedeemDetails.findByNoOfPoints", query = "SELECT r FROM RedeemDetails r WHERE r.noOfPoints = :noOfPoints"),
    @NamedQuery(name = "RedeemDetails.findByStatus", query = "SELECT r FROM RedeemDetails r WHERE r.status = :status"),
    @NamedQuery(name = "RedeemDetails.findByRedemptionStatusUpdatedDate", query = "SELECT r FROM RedeemDetails r WHERE r.redemptionStatusUpdatedDate = :redemptionStatusUpdatedDate"),
    @NamedQuery(name = "RedeemDetails.findByRedemptionStatusUpdatedBy", query = "SELECT r FROM RedeemDetails r WHERE r.redemptionStatusUpdatedBy = :redemptionStatusUpdatedBy"),
    @NamedQuery(name = "RedeemDetails.findByAddedBy", query = "SELECT r FROM RedeemDetails r WHERE r.addedBy = :addedBy"),
    @NamedQuery(name = "RedeemDetails.findByAddedDate", query = "SELECT r FROM RedeemDetails r WHERE r.addedDate = :addedDate"),
    @NamedQuery(name = "RedeemDetails.findByModifiedBy", query = "SELECT r FROM RedeemDetails r WHERE r.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "RedeemDetails.findByModifiedDate", query = "SELECT r FROM RedeemDetails r WHERE r.modifiedDate = :modifiedDate")})
public class RedeemDetails implements Serializable {
    @OneToMany(mappedBy = "redemptionReferenceId")
    private List<MemberPointLedgerTrx> memberPointLedgerTrxList;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "redemption_reference_id")
    private Integer redemptionReferenceId;
    @Basic(optional = false)
    @Column(name = "redemption_requested_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date redemptionRequestedDate;
    @Basic(optional = false)
    @Column(name = "collection_point")
    private String collectionPoint;

    public Integer getCheckMembershipCard() {
        return checkMembershipCard;
    }

    public void setCheckMembershipCard(Integer checkMembershipCard) {
        this.checkMembershipCard = checkMembershipCard;
    }

    public Integer getCheckNIC() {
        return checkNIC;
    }

    public void setCheckNIC(Integer checkNIC) {
        this.checkNIC = checkNIC;
    }

    public Integer getCheckDrivingLicense() {
        return checkDrivingLicense;
    }

    public void setCheckDrivingLicense(Integer checkDrivingLicense) {
        this.checkDrivingLicense = checkDrivingLicense;
    }

    public Integer getCheckPassport() {
        return checkPassport;
    }

    public void setCheckPassport(Integer checkPassport) {
        this.checkPassport = checkPassport;
    }

    public Integer getCheckPhotograph() {
        return checkPhotograph;
    }

    public void setCheckPhotograph(Integer checkPhotograph) {
        this.checkPhotograph = checkPhotograph;
    }

    @Basic(optional = false)
    @Column(name = "membership_check")
    private Integer checkMembershipCard;
    @Basic(optional = false)
    @Column(name = "nic_check")
    private Integer checkNIC;
    @Basic(optional = false)
    @Column(name = "passport_check")
    private Integer checkPassport;
    @Basic(optional = false)
    @Column(name = "driving_license_check")
    private Integer checkDrivingLicense;
    @Basic(optional = false)
    @Column(name = "photograph_check")
    private Integer checkPhotograph;
    @Basic(optional = false)
    @Column(name = "no_of_points")
    private double noOfPoints;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Column(name = "redemption_status_updated_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date redemptionStatusUpdatedDate;
    @Column(name = "redemption_status_updated_by")
    private String redemptionStatusUpdatedBy;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redemptionReferenceId")
    private List<RedeemDetailsStatusHistory> redeemDetailsStHisList;
    @JoinColumn(name = "member_code", referencedColumnName = "member_code")
    @ManyToOne(optional = false)
    private MemberMaster memberCode;
    @JoinColumn(name = "collection_showroom_name", referencedColumnName = "showroom_name")
    @ManyToOne
    private Showroom collectionShowroomName;
    @JoinColumn(name = "requested_from_showroom", referencedColumnName = "showroom_name")
    @ManyToOne(optional = false)
    private Showroom requestedFromShowroom;
    @JoinColumn(name = "redemption_type", referencedColumnName = "redemption_type")
    @ManyToOne(optional = false)
    private RedeemType redemptionType;

    public RedeemDetails() {
    }

    public RedeemDetails(Integer redemptionReferenceId) {
        this.redemptionReferenceId = redemptionReferenceId;
    }

    public RedeemDetails(Integer redemptionReferenceId, Date redemptionRequestedDate, String collectionPoint, double noOfPoints, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.redemptionReferenceId = redemptionReferenceId;
        this.redemptionRequestedDate = redemptionRequestedDate;
        this.collectionPoint = collectionPoint;
        this.noOfPoints = noOfPoints;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public Integer getRedemptionReferenceId() {
        return redemptionReferenceId;
    }

    public void setRedemptionReferenceId(Integer redemptionReferenceId) {
        this.redemptionReferenceId = redemptionReferenceId;
    }

    public Date getRedemptionRequestedDate() {
        return redemptionRequestedDate;
    }

    public void setRedemptionRequestedDate(Date redemptionRequestedDate) {
        this.redemptionRequestedDate = redemptionRequestedDate;
    }

    public String getCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(String collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public double getNoOfPoints() {
        return noOfPoints;
    }

    public void setNoOfPoints(double noOfPoints) {
        this.noOfPoints = noOfPoints;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRedemptionStatusUpdatedDate() {
        return redemptionStatusUpdatedDate;
    }

    public void setRedemptionStatusUpdatedDate(Date redemptionStatusUpdatedDate) {
        this.redemptionStatusUpdatedDate = redemptionStatusUpdatedDate;
    }

    public String getRedemptionStatusUpdatedBy() {
        return redemptionStatusUpdatedBy;
    }

    public void setRedemptionStatusUpdatedBy(String redemptionStatusUpdatedBy) {
        this.redemptionStatusUpdatedBy = redemptionStatusUpdatedBy;
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
    public List<RedeemDetailsStatusHistory> getRedeemDetailsStHisList() {
        return redeemDetailsStHisList;
    }

    public void setRedeemDetailsStHisList(List<RedeemDetailsStatusHistory> redeemDetailsStHisList) {
        this.redeemDetailsStHisList = redeemDetailsStHisList;
    }

    public MemberMaster getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(MemberMaster memberCode) {
        this.memberCode = memberCode;
    }

    public Showroom getCollectionShowroomName() {
        return collectionShowroomName;
    }

    public void setCollectionShowroomName(Showroom collectionShowroomName) {
        this.collectionShowroomName = collectionShowroomName;
    }

    public Showroom getRequestedFromShowroom() {
        return requestedFromShowroom;
    }

    public void setRequestedFromShowroom(Showroom requestedFromShowroom) {
        this.requestedFromShowroom = requestedFromShowroom;
    }

    public RedeemType getRedemptionType() {
        return redemptionType;
    }

    public void setRedemptionType(RedeemType redemptionType) {
        this.redemptionType = redemptionType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redemptionReferenceId != null ? redemptionReferenceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedeemDetails)) {
            return false;
        }
        RedeemDetails other = (RedeemDetails) object;
        if ((this.redemptionReferenceId == null && other.redemptionReferenceId != null) || (this.redemptionReferenceId != null && !this.redemptionReferenceId.equals(other.redemptionReferenceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RedeemDetails[ redemptionReferenceId=" + redemptionReferenceId + " ]";
    }

    @XmlTransient
    public List<MemberPointLedgerTrx> getMemberPointLedgerTrxList() {
        return memberPointLedgerTrxList;
    }

    public void setMemberPointLedgerTrxList(List<MemberPointLedgerTrx> memberPointLedgerTrxList) {
        this.memberPointLedgerTrxList = memberPointLedgerTrxList;
    }
    
}
