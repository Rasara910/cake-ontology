/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.TransactionTypeDao;
import com.sw.ontology.core.service.TransactionTypeService;
import com.sw.ontology.model.TransactionType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amith
 */
@Service
public class TransactionTypeServiceImpl implements TransactionTypeService {

    @Autowired
    private TransactionTypeDao transactionTypeDao;
    
    @Override
    public TransactionType findByType(String type) {
       return transactionTypeDao.read(type);
    }
    
}
