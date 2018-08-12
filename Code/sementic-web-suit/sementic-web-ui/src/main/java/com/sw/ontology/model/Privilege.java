/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Created by praveen on 8/12/18
 */

@Entity
@Table(name = "sw_privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilege.findAll", query = "SELECT p FROM Privilege p"),
    @NamedQuery(name = "Privilege.findByPrivilegeCode", query = "SELECT p FROM Privilege p WHERE p.privilegeCode = :privilegeCode"),
    @NamedQuery(name = "Privilege.findByPrivilegeName", query = "SELECT p FROM Privilege p WHERE p.privilegeName = :privilegeName"),
    @NamedQuery(name = "Privilege.findByStatus", query = "SELECT p FROM Privilege p WHERE p.status = :status")})
public class Privilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "privilege_code")
    private String privilegeCode;
    @Basic(optional = false)
    @Column(name = "privilege_name")
    private String privilegeName;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;


    public Privilege() {
    }

    public Privilege(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public Privilege(String privilegeCode, String privilegeName, String status) {
        this.privilegeCode = privilegeCode;
        this.privilegeName = privilegeName;
        this.status = status;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (privilegeCode != null ? privilegeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilege)) {
            return false;
        }
        Privilege other = (Privilege) object;
        if ((this.privilegeCode == null && other.privilegeCode != null) || (this.privilegeCode != null && !this.privilegeCode.equals(other.privilegeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Privilege[ privilegeCode=" + privilegeCode + " ]";
    }
    
}
