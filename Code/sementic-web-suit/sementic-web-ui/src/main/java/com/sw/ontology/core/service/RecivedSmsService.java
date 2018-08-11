/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;

/**
 *
 * @author Amith
 */
public interface RecivedSmsService {

    public void save(String originatedNo, String msg, String time) throws SystemException;
}
