/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.EmailDao;
import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.core.service.EmailService;
import com.sw.ontology.model.Email;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailDao emailDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public void save(Email email) throws SystemException {
        try {
            emailDao.create(email);
        } catch (Exception e) {
            logger.error("error occured in save()", e);
            throw new SystemException("error", e);
        }
    }

    @Transactional
    @Override
    public void update(Email email) throws SystemException {
        try {
            emailDao.update(email);
        } catch (Exception e) {
            logger.error("error occured in update()", e);
            throw new SystemException("ERROR", e);
        }
    }

    @Override
    public List<Email> findByStaus(String status) {
        String sql = "SELECT a FROM Email a WHERE a.status=:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", status);
        return emailDao.findbyQuery(sql, params);
    }

}
