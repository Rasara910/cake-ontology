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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "fgl_member_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberClass.findAll", query = "SELECT m FROM MemberClass m"),
    @NamedQuery(name = "MemberClass.findByMemberClass", query = "SELECT m FROM MemberClass m WHERE m.memberClass = :memberClass"),
    @NamedQuery(name = "MemberClass.findByStatus", query = "SELECT m FROM MemberClass m WHERE m.status = :status"),
    @NamedQuery(name = "MemberClass.findByAddedBy", query = "SELECT m FROM MemberClass m WHERE m.addedBy = :addedBy"),
    @NamedQuery(name = "MemberClass.findByAddedDate", query = "SELECT m FROM MemberClass m WHERE m.addedDate = :addedDate"),
    @NamedQuery(name = "MemberClass.findByModifiedBy", query = "SELECT m FROM MemberClass m WHERE m.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "MemberClass.findByModifiedDate", query = "SELECT m FROM MemberClass m WHERE m.modifiedDate = :modifiedDate")})
public class MemberClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "member_class")
    private String memberClass;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Lob
    @Column(name = "description")
    private String description;
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
    @OneToMany(mappedBy = "memberClass")
    private List<ProgramRule> programRuleList;
    @OneToMany(mappedBy = "memberClass")
    private List<MemberMaster> memberMasterList;

    public MemberClass() {
    }

    public MemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    public MemberClass(String memberClass, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.memberClass = memberClass;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getMemberClass() {
        return memberClass;
    }

    public void setMemberClass(String memberClass) {
        this.memberClass = memberClass;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
    public List<ProgramRule> getProgramRuleList() {
        return programRuleList;
    }

    public void setProgramRuleList(List<ProgramRule> programRuleList) {
        this.programRuleList = programRuleList;
    }

    @XmlTransient
    public List<MemberMaster> getMemberMasterList() {
        return memberMasterList;
    }

    public void setMemberMasterList(List<MemberMaster> memberMasterList) {
        this.memberMasterList = memberMasterList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberClass != null ? memberClass.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberClass)) {
            return false;
        }
        MemberClass other = (MemberClass) object;
        if ((this.memberClass == null && other.memberClass != null) || (this.memberClass != null && !this.memberClass.equals(other.memberClass))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MemberClass[ memberClass=" + memberClass + " ]";
    }
    
}
