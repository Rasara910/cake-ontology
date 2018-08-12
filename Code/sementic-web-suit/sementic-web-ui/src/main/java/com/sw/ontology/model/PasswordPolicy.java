/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by praveen on 8/12/18
 */

@Entity
@Table(name = "sw_password_policy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PasswordPolicy.findAll", query = "SELECT p FROM PasswordPolicy p"),
    @NamedQuery(name = "PasswordPolicy.findByPolicyId", query = "SELECT p FROM PasswordPolicy p WHERE p.policyId = :policyId"),
    @NamedQuery(name = "PasswordPolicy.findByName", query = "SELECT p FROM PasswordPolicy p WHERE p.name = :name")})
public class PasswordPolicy implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status")
    private String status;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "policy_id")
    private Integer policyId;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "policyId")
    private List<User> userList;

    public PasswordPolicy() {
    }

    public PasswordPolicy(Integer policyId) {
        this.policyId = policyId;
    }

    public PasswordPolicy(Integer policyId, String name) {
        this.policyId = policyId;
        this.name = name;
    }

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PasswordPolicy)) {
            return false;
        }
        PasswordPolicy other = (PasswordPolicy) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PasswordPolicy[ policyId=" + policyId + " ]";
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
