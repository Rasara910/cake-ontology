/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.TransactionType;

/**
 *
 * @author Amith
 */
public interface TransactionTypeService {
    
    public TransactionType findByType(String type);
    
}
