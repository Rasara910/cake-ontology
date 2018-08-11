/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.SmsLogDao;
import com.sw.ontology.core.service.SmsLogService;
import com.sw.ontology.model.SmsLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class SmsLogServiceImpl implements SmsLogService {

    @Autowired
    private SmsLogDao smsLogDao;

    @Transactional
    @Override
    public void save(SmsLog smsLog) throws Exception {
        smsLogDao.create(smsLog);
    }

    @Transactional
    @Override
    public void update(SmsLog smsLog) throws Exception {
        smsLogDao.update(smsLog);
    }

    @Override
    public List<SmsLog> findByStatus(String status) {
        String sql = "SELECT a FROM SmsLog a WHERE a.status=:status ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("status", status);
        return smsLogDao.findbyQuery(sql, params);
    }

    @Override
    public List<SmsLog> findByMemberCode(String memeberCode) {
        String sql = "SELECT a FROM SmsLog a WHERE a.memberCode.memberCode=:memberCode ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberCode", memeberCode);
        return smsLogDao.findbyQuery(sql, params);
    }
    
    @Override
    public List<SmsLog> findByExtCrmCode(String extCrmCode) {
        String sql = "SELECT a FROM SmsLog a WHERE a.memberCode.extCrmCode=:extCrmCode ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("extCrmCode", extCrmCode);
        return smsLogDao.findbyQuery(sql, params);
    }
    
    @Override
    public List<SmsLog> findByBoth(String extCrmCode,String memeberCode) {
        String sql = "SELECT a FROM SmsLog a WHERE a.memberCode.extCrmCode=:extCrmCode AND a.memberCode.memberCode=:memberCode ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("extCrmCode", extCrmCode);
        params.put("memberCode", memeberCode);
        return smsLogDao.findbyQuery(sql, params);
    }

}
