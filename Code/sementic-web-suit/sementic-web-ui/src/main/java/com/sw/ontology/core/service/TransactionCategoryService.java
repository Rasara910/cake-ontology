/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.TransactionCategory;

/**
 *
 * @author Amith
 */
public interface TransactionCategoryService {
    
    public TransactionCategory findByCategory(String category);
    
}
