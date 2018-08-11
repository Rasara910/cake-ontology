/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.model.SmsLog;

import java.util.List;

/**
 *
 * @author Amith
 */
public interface SmsLogService {

    public void save(SmsLog smsLog) throws Exception;

    public void update(SmsLog smsLog) throws Exception;

    public List<SmsLog> findByStatus(String status);

    public List<SmsLog> findByMemberCode(String memeberCode);
    
    public List<SmsLog> findByExtCrmCode(String extCrmCode);
    
    public List<SmsLog> findByBoth(String extCrmCode,String memeberCode);
}
