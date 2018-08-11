/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Amith
 */
@Embeddable
public class RolePrivilegePK implements Serializable {
    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;
    @Basic(optional = false)
    @Column(name = "privilege_code")
    private String privilegeCode;

    public RolePrivilegePK() {
    }

    public RolePrivilegePK(String roleName, String privilegeCode) {
        this.roleName = roleName;
        this.privilegeCode = privilegeCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getPrivilegeCode() {
        return privilegeCode;
    }

    public void setPrivilegeCode(String privilegeCode) {
        this.privilegeCode = privilegeCode;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleName != null ? roleName.hashCode() : 0);
        hash += (privilegeCode != null ? privilegeCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePrivilegePK)) {
            return false;
        }
        RolePrivilegePK other = (RolePrivilegePK) object;
        if ((this.roleName == null && other.roleName != null) || (this.roleName != null && !this.roleName.equals(other.roleName))) {
            return false;
        }
        if ((this.privilegeCode == null && other.privilegeCode != null) || (this.privilegeCode != null && !this.privilegeCode.equals(other.privilegeCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolePrivilegePK[ roleName=" + roleName + ", privilegeCode=" + privilegeCode + " ]";
    }
    
}
