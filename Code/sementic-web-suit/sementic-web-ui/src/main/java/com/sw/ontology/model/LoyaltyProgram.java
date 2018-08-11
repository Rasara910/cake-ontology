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
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_loyalty_program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoyaltyProgram.findAll", query = "SELECT l FROM LoyaltyProgram l"),
    @NamedQuery(name = "LoyaltyProgram.findByProgramId", query = "SELECT l FROM LoyaltyProgram l WHERE l.programId = :programId"),
    @NamedQuery(name = "LoyaltyProgram.findByProgramName", query = "SELECT l FROM LoyaltyProgram l WHERE l.programName = :programName"),
    @NamedQuery(name = "LoyaltyProgram.findByProgramType", query = "SELECT l FROM LoyaltyProgram l WHERE l.programType = :programType")})
public class LoyaltyProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "program_id")
    private String programId;
    @Basic(optional = false)
    @Column(name = "program_name")
    private String programName;
    @Basic(optional = false)
    @Column(name = "program_type")
    private String programType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private List<ProgramRule> programRuleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private List<ProgramPeriod> programPeriodList;

    public LoyaltyProgram() {
    }

    public LoyaltyProgram(String programId) {
        this.programId = programId;
    }

    public LoyaltyProgram(String programId, String programName, String programType) {
        this.programId = programId;
        this.programName = programName;
        this.programType = programType;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramType() {
        return programType;
    }

    public void setProgramType(String programType) {
        this.programType = programType;
    }

    @XmlTransient
    public List<ProgramRule> getProgramRuleList() {
        return programRuleList;
    }

    public void setProgramRuleList(List<ProgramRule> programRuleList) {
        this.programRuleList = programRuleList;
    }

    @XmlTransient
    public List<ProgramPeriod> getProgramPeriodList() {
        return programPeriodList;
    }

    public void setProgramPeriodList(List<ProgramPeriod> programPeriodList) {
        this.programPeriodList = programPeriodList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoyaltyProgram)) {
            return false;
        }
        LoyaltyProgram other = (LoyaltyProgram) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LoyaltyProgram[ programId=" + programId + " ]";
    }
    
}
