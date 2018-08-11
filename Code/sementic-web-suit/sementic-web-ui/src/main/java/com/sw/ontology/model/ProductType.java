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
@Table(name = "fgl_product_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductType.findAll", query = "SELECT p FROM ProductType p"),
    @NamedQuery(name = "ProductType.findByProductType", query = "SELECT p FROM ProductType p WHERE p.productType = :productType"),
    @NamedQuery(name = "ProductType.findByStatus", query = "SELECT p FROM ProductType p WHERE p.status = :status"),
    @NamedQuery(name = "ProductType.findByAddedDate", query = "SELECT p FROM ProductType p WHERE p.addedDate = :addedDate"),
    @NamedQuery(name = "ProductType.findByAddedBy", query = "SELECT p FROM ProductType p WHERE p.addedBy = :addedBy"),
    @NamedQuery(name = "ProductType.findByModifiedDate", query = "SELECT p FROM ProductType p WHERE p.modifiedDate = :modifiedDate"),
    @NamedQuery(name = "ProductType.findByModifiedBy", query = "SELECT p FROM ProductType p WHERE p.modifiedBy = :modifiedBy")})
public class ProductType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "product_type")
    private String productType;
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @Column(name = "added_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date addedDate;
    @Basic(optional = false)
    @Column(name = "added_by")
    private String addedBy;
    @Basic(optional = false)
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;
    @Basic(optional = false)
    @Column(name = "modified_by")
    private String modifiedBy;
    @OneToMany(mappedBy = "productType")
    private List<ProgramRule> programRuleList;

    public ProductType() {
    }

    public ProductType(String productType) {
        this.productType = productType;
    }

    public ProductType(String productType, String status, Date addedDate, String addedBy, Date modifiedDate, String modifiedBy) {
        this.productType = productType;
        this.status = status;
        this.addedDate = addedDate;
        this.addedBy = addedBy;
        this.modifiedDate = modifiedDate;
        this.modifiedBy = modifiedBy;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @XmlTransient
    public List<ProgramRule> getProgramRuleList() {
        return programRuleList;
    }

    public void setProgramRuleList(List<ProgramRule> programRuleList) {
        this.programRuleList = programRuleList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productType != null ? productType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductType)) {
            return false;
        }
        ProductType other = (ProductType) object;
        if ((this.productType == null && other.productType != null) || (this.productType != null && !this.productType.equals(other.productType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ProductType[ productType=" + productType + " ]";
    }
    
}
