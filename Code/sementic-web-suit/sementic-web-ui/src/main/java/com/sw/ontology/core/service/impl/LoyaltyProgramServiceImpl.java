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

import com.sw.ontology.core.dao.LoyaltyProgramDao;
import com.sw.ontology.core.dao.ProgramRuleDao;
import com.sw.ontology.core.service.LoyaltyProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.LoyaltyProgram;
import com.sw.ontology.model.ProgramRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Amith
 */
@Service
public class LoyaltyProgramServiceImpl implements LoyaltyProgramService {

    private final Logger logger = LoggerFactory.getLogger(LoyaltyProgramServiceImpl.class);

    @Autowired
    private LoyaltyProgramDao loyaltyProgramDao;
    @Autowired
    private ProgramRuleDao programRuleDao;

    @Transactional
    @Override
    public void save(LoyaltyProgram loyaltyProgram, List<ProgramRule> programRules) throws SystemException {
        try {
            loyaltyProgramDao.create(loyaltyProgram);
            //save rules
            for (ProgramRule programRule : programRules) {
                programRule.setProgramId(loyaltyProgram);
                programRule.setAddedBy("admin");
                programRule.setAddedDate(new Date());
                programRule.setModifiedBy("admin");
                programRule.setModifiedDate(new Date());
                programRuleDao.create(programRule);
            }
        } catch (Exception e) {
            logger.error("error occured in save()", e);
            throw new SystemException("error", e);
        }
    }

    @Override
    public LoyaltyProgram findbyProgramId(String programId) {
        return loyaltyProgramDao.read(programId);
    }

    @Override
    public List<LoyaltyProgram> findAll() {
        return loyaltyProgramDao.findAll();
    }

    @Override
    public List<LoyaltyProgram> findLike(String programId, String programName, String programType) {
        String sql = "SELECT l FROM LoyaltyProgram l WHERE 1=1   ";
        Map<String, Object> params = new HashMap<String, Object>();
        if (!programId.isEmpty()) {
            sql += " AND l.programId LIKE :programId";
            params.put("programId", "%" + programId + "%");
        }
        if (!programName.isEmpty()) {
            sql += " AND l.programName LIKE :programName";
            params.put("programName", "%" + programName + "%");
        }
        if (!programType.isEmpty()) {
            sql += " AND l.programType LIKE :programType";
            params.put("programType", "%" + programType + "%");
        }
        return loyaltyProgramDao.findbyQuery(sql, params);
    }
}
