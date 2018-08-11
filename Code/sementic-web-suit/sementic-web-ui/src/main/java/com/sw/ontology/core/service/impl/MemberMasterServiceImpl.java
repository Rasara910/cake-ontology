/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import com.sw.ontology.core.dao.MemberMasterDao;
import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.core.service.MemberMasterService;
import com.sw.ontology.model.MemberMaster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Amith
 */
@Service
public class MemberMasterServiceImpl implements MemberMasterService {

    private final Logger logger = LoggerFactory.getLogger(MemberMasterServiceImpl.class);

    @Autowired
    private MemberMasterDao memberMasterDao;

    @Transactional
    @Override
    public void save(MemberMaster memberMaster) throws SystemException {
        try {
            memberMasterDao.create(memberMaster);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new SystemException("ERROR", e);
        }

    }
    
     @Transactional
    @Override
    public void update(MemberMaster memberMaster) throws SystemException {
        try {
            memberMasterDao.update(memberMaster);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new SystemException("ERROR", e);
        }

    }

    @Override
    public MemberMaster findByMemberCode(String code) {
        return memberMasterDao.read(code);
    }

    @Override
    public MemberMaster findByMobileNo(String mobileNo) {
        String sql = "SELECT a FROM MemberMaster a WHERE a.contactMobile1=:mobile1  ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mobile1", mobileNo);
        return memberMasterDao.findbyQuerySingle(sql, params);
    }

    @Override
    public List<MemberMaster> findLikeMobileNo(String mobileNo) {

        String sql = "SELECT a FROM MemberMaster a WHERE a.contactMobile1 LIKE :mobile1  ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("mobile1", "%" + mobileNo + "%");
        return memberMasterDao.findbyQuery(sql, params);
    }

    @Override
    public List<MemberMaster> findLikeMemberCode(String memberCode) {

        String sql = "SELECT a FROM MemberMaster a WHERE a.memberCode LIKE :memberCode  ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberCode", "%" + memberCode + "%");
        return memberMasterDao.findbyQuery(sql, params);
    }

    @Override
    public List<MemberMaster> findAll() {
        return memberMasterDao.findAll();
    }

    @Override
    public List<MemberMaster> findLike(String name, String code, String nic, String contatNo) {
        String sql = "SELECT a FROM MemberMaster a WHERE 1=1   ";
        Map<String, Object> params = new HashMap<String, Object>();
        if (!name.isEmpty()) {
            sql += " AND (a.name1 LIKE :name1  OR a.name2 LIKE :name2 OR a.name2 LIKE :name3 )";
            params.put("name1", "%" + name + "%");
            params.put("name2", "%" + name + "%");
            params.put("name3", "%" + name + "%");
        }
        if (!code.isEmpty()) {
            sql += " AND a.memberCode LIKE :code";
            params.put("code", "%" + code + "%");
        }
        if (!nic.isEmpty()) {
            sql += " AND a.nic LIKE :nic";
            params.put("nic", "%" + nic + "%");
        }
        if (!contatNo.isEmpty()) {
            sql += " AND a.contactPhone1 LIKE :contactPhone1 OR a.contactMobile1 LIKE :contactMobile1";
            params.put("contactPhone1", "%" + contatNo + "%");
            params.put("contactMobile1", "%" + contatNo + "%");
        }
        return memberMasterDao.findbyQuery(sql, params);
    }

}
