/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_role_privilege")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RolePrivilege.findAll", query = "SELECT r FROM RolePrivilege r"),
    @NamedQuery(name = "RolePrivilege.findByRoleName", query = "SELECT r FROM RolePrivilege r WHERE r.rolePrivilegePK.roleName = :roleName"),
    @NamedQuery(name = "RolePrivilege.findByPrivilegeCode", query = "SELECT r FROM RolePrivilege r WHERE r.rolePrivilegePK.privilegeCode = :privilegeCode"),
    @NamedQuery(name = "RolePrivilege.findByStatus", query = "SELECT r FROM RolePrivilege r WHERE r.status = :status")})
public class RolePrivilege implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RolePrivilegePK rolePrivilegePK;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "privilege_code", referencedColumnName = "privilege_code", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Privilege privilege;
    @JoinColumn(name = "role_name", referencedColumnName = "role_name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Role role;

    public RolePrivilege() {
    }

    public RolePrivilege(RolePrivilegePK rolePrivilegePK) {
        this.rolePrivilegePK = rolePrivilegePK;
    }

    public RolePrivilege(RolePrivilegePK rolePrivilegePK, String status) {
        this.rolePrivilegePK = rolePrivilegePK;
        this.status = status;
    }

    public RolePrivilege(String roleName, String privilegeCode) {
        this.rolePrivilegePK = new RolePrivilegePK(roleName, privilegeCode);
    }

    public RolePrivilegePK getRolePrivilegePK() {
        return rolePrivilegePK;
    }

    public void setRolePrivilegePK(RolePrivilegePK rolePrivilegePK) {
        this.rolePrivilegePK = rolePrivilegePK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Privilege getPrivilege() {
        return privilege;
    }

    public void setPrivilege(Privilege privilege) {
        this.privilege = privilege;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rolePrivilegePK != null ? rolePrivilegePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RolePrivilege)) {
            return false;
        }
        RolePrivilege other = (RolePrivilege) object;
        if ((this.rolePrivilegePK == null && other.rolePrivilegePK != null) || (this.rolePrivilegePK != null && !this.rolePrivilegePK.equals(other.rolePrivilegePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RolePrivilege[ rolePrivilegePK=" + rolePrivilegePK + " ]";
    }
    
}
