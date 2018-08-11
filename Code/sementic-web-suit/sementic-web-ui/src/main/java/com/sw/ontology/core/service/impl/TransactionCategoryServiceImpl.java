/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.TransactionCategoryDao;
import com.sw.ontology.core.service.TransactionCategoryService;
import com.sw.ontology.model.TransactionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amith
 */
@Service
public class TransactionCategoryServiceImpl implements TransactionCategoryService {

    @Autowired
    private TransactionCategoryDao transactionCategoryDao;
    
    @Override
    public TransactionCategory findByCategory(String category) {
      return transactionCategoryDao.read(category);
    }
    
}
