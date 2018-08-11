/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Amith
 */
@Entity
@Table(name = "fgl_program_period")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramPeriod.findAll", query = "SELECT p FROM ProgramPeriod p"),
    @NamedQuery(name = "ProgramPeriod.findByPeriodId", query = "SELECT p FROM ProgramPeriod p WHERE p.periodId = :periodId"),
    @NamedQuery(name = "ProgramPeriod.findByStartDate", query = "SELECT p FROM ProgramPeriod p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "ProgramPeriod.findByEndDate", query = "SELECT p FROM ProgramPeriod p WHERE p.endDate = :endDate")})
public class ProgramPeriod implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "period_id")
    private Integer periodId;
    @Basic(optional = false)
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @Column(name = "end_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private LoyaltyProgram programId;

    public ProgramPeriod() {
    }

    public ProgramPeriod(Integer periodId) {
        this.periodId = periodId;
    }

    public ProgramPeriod(Integer periodId, Date startDate, Date endDate) {
        this.periodId = periodId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getPeriodId() {
        return periodId;
    }

    public void setPeriodId(Integer periodId) {
        this.periodId = periodId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public LoyaltyProgram getProgramId() {
        return programId;
    }

    public void setProgramId(LoyaltyProgram programId) {
        this.programId = programId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (periodId != null ? periodId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramPeriod)) {
            return false;
        }
        ProgramPeriod other = (ProgramPeriod) object;
        if ((this.periodId == null && other.periodId != null) || (this.periodId != null && !this.periodId.equals(other.periodId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProgramPeriod[ periodId=" + periodId + " ]";
    }
    
}
