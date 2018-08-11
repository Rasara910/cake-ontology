/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.SalutationDao;
import com.sw.ontology.core.service.SalutationService;
import com.sw.ontology.model.Salutation;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class SalutationServiceImpl implements SalutationService {

    @Autowired
    private SalutationDao salutationDao;
    
    @Transactional
    @Override
    public void save(Salutation salutation) throws Exception {
       salutationDao.create(salutation);
    }

    @Override
    public Salutation findBySalutation(String salutation) {
     return salutationDao.read(salutation);
    }

    @Override
    public List<Salutation> findAll() {
      return salutationDao.findAll();
    }
    
}
