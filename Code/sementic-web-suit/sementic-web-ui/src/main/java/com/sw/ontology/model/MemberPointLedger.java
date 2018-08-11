/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_member_point_ledger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MemberPointLedger.findAll", query = "SELECT m FROM MemberPointLedger m"),
    @NamedQuery(name = "MemberPointLedger.findByMemberCode", query = "SELECT m FROM MemberPointLedger m WHERE m.memberCode = :memberCode"),
    @NamedQuery(name = "MemberPointLedger.findByPointBalance", query = "SELECT m FROM MemberPointLedger m WHERE m.pointBalance = :pointBalance")})
public class MemberPointLedger implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "member_code")
    private String memberCode;
    @Basic(optional = false)
    @Column(name = "point_balance")
    private double pointBalance;
    @JoinColumn(name = "member_code", referencedColumnName = "member_code", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private MemberMaster memberMaster;

    public MemberPointLedger() {
    }

    public MemberPointLedger(String memberCode) {
        this.memberCode = memberCode;
    }

    public MemberPointLedger(String memberCode, double pointBalance) {
        this.memberCode = memberCode;
        this.pointBalance = pointBalance;
    }

    public String getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(String memberCode) {
        this.memberCode = memberCode;
    }

    public double getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(double pointBalance) {
        this.pointBalance = pointBalance;
    }

    public MemberMaster getMemberMaster() {
        return memberMaster;
    }

    public void setMemberMaster(MemberMaster memberMaster) {
        this.memberMaster = memberMaster;
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
        if (!(object instanceof MemberPointLedger)) {
            return false;
        }
        MemberPointLedger other = (MemberPointLedger) object;
        if ((this.memberCode == null && other.memberCode != null) || (this.memberCode != null && !this.memberCode.equals(other.memberCode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MemberPointLedger[ memberCode=" + memberCode + " ]";
    }
    
}
