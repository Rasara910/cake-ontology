/**
 *
 */
package com.sw.ontology.core.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.sw.ontology.core.dao.PrivilegeDao;
import com.sw.ontology.core.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.ontology.model.Privilege;

/**
 * Created by praveen on 8/12/18
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;


    private final static Logger LOGGER = Logger.getLogger(PrivilegeServiceImpl.class.getName());

    @Override
    public List<Privilege> findAll() {

        return privilegeDao.findAll();
    }

    @Override
    public Privilege findByPrivilegeName(String privilegeName) {

        return privilegeDao.read(privilegeName);
    }



}
