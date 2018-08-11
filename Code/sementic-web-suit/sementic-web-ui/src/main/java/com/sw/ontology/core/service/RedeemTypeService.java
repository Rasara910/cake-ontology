/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.RedeemType;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface RedeemTypeService {
    
    public RedeemType findByType(String type);
    
    public List<RedeemType> findAll();
    
}
