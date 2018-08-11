/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.Email;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface EmailService {

    public void save(Email email) throws SystemException;

    public void update(Email email) throws SystemException;

    public List<Email> findByStaus(String status);
}
