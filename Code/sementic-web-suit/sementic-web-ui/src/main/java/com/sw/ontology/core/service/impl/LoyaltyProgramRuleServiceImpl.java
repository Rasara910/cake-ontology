/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sw.ontology.core.dao.ProgramRuleDao;
import com.sw.ontology.core.service.LoyaltyProgramRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.ProgramRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Amith
 */
@Service
public class LoyaltyProgramRuleServiceImpl implements LoyaltyProgramRuleService {

    private final Logger logger = LoggerFactory.getLogger(LoyaltyProgramRuleServiceImpl.class);

    @Autowired
    private ProgramRuleDao programRuleDao;

    @Override
    public void save(ProgramRule programRule) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public void update(ProgramRule programRule) throws SystemException {
        try {
            programRuleDao.update(programRule);
        } catch (Exception e) {
            logger.error("error occured in update()", e);
            throw new SystemException("error", e);
        }
    }

    @Override
    public ProgramRule findBy(String memberType, String memberClass, String productType, Date inDate, String status) {
        String sql = "SELECT a FROM ProgramRule a WHERE a.memberType.memberType=:memberType ";
        sql += " AND a.memberClass.memberClass=:memberClass AND a.productType.productType=:productType ";
        sql += " AND ( a.startDate <= :inDate )";
        sql += " AND a.status=:status";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberType", memberType);
        params.put("memberClass", memberClass);
        params.put("productType", productType);
        params.put("inDate", inDate);
        params.put("status", status);
        return programRuleDao.findbyQuerySingle(sql, params);
    }

    @Override
    public ProgramRule findByRuleId(Integer ruleId) {
        return programRuleDao.read(ruleId);
    }

    @Override
    public List<ProgramRule> findAll() {
        return programRuleDao.findAll();
    }

    @Override
    public List<ProgramRule> findByProgramId(String programId) {
        String sql = "SELECT l FROM ProgramRule l WHERE l.programId.programId =:programId";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("programId", programId);
        return programRuleDao.findbyQuery(sql, params);
    }

    @Override
    public boolean findDuplicate(String memberType, String memberClass, String productType, Date startDate, String status) {
        String sql = "SELECT l FROM ProgramRule l WHERE l.memberType.memberType=:memberType ";
        sql += " AND l.memberClass.memberClass=:memberClass AND l.productType.productType=:productType ";
        sql += " AND l.status=:status";
        sql += " AND (l.startDate <= :startDate)  ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberType", memberType);
        params.put("memberClass", memberClass);
        params.put("productType", productType);
        params.put("status", status);
        params.put("startDate", startDate);
        List<ProgramRule> list = programRuleDao.findbyQuery(sql, params);
        if (list != null && !list.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
