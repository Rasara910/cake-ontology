/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.ShowroomDao;
import com.sw.ontology.core.service.ShowroomService;
import com.sw.ontology.model.Showroom;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class ShowroomServiceImpl implements ShowroomService {

    @Autowired
    private ShowroomDao showroomDao;
    
    @Override
    public Showroom findByName(String name) {
      return showroomDao.read(name);
    }

    @Override
    public List<Showroom> findAll() {
      return showroomDao.findAll();
    }

    @Transactional
    @Override
    public void save(Showroom showroom) throws Exception {
       showroomDao.create(showroom);
    }
    
}
