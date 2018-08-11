/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.RedeemTypeDao;
import com.sw.ontology.core.service.RedeemTypeService;
import com.sw.ontology.model.RedeemType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amith
 */
@Service
public class RedeemTypeServiceImpl implements RedeemTypeService {

    @Autowired
    private RedeemTypeDao redeemTypeDao;

    @Override
    public RedeemType findByType(String type) {
        return redeemTypeDao.read(type);
    }

    @Override
    public List<RedeemType> findAll() {
      return redeemTypeDao.findAll();
    }

}
