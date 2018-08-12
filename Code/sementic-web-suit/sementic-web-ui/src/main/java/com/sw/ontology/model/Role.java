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
 * Created by praveen on 8/12/18
 */

@Entity
@Table(name = "sw_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findByRoleName", query = "SELECT r FROM Role r WHERE r.roleName = :roleName"),
    @NamedQuery(name = "Role.findByStatus", query = "SELECT r FROM Role r WHERE r.status = :status"),
    @NamedQuery(name = "Role.findByAddedBy", query = "SELECT r FROM Role r WHERE r.addedBy = :addedBy"),
    @NamedQuery(name = "Role.findByAddedDate", query = "SELECT r FROM Role r WHERE r.addedDate = :addedDate"),
    @NamedQuery(name = "Role.findByModifiedBy", query = "SELECT r FROM Role r WHERE r.modifiedBy = :modifiedBy"),
    @NamedQuery(name = "Role.findByModifiedDate", query = "SELECT r FROM Role r WHERE r.modifiedDate = :modifiedDate")})
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleName")
    private List<User> userList;

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName, String status, String addedBy, Date addedDate, String modifiedBy, Date modifiedDate) {
        this.roleName = roleName;
        this.status = status;
        this.addedBy = addedBy;
        this.addedDate = addedDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleName != null ? roleName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Role[ roleName=" + roleName + " ]";
    }
    
}
