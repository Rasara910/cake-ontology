/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.ProgramRule;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface LoyaltyProgramRuleService {

    public void save(ProgramRule programRule) throws SystemException;
    
    public void update(ProgramRule programRule) throws SystemException;

    public ProgramRule findBy(String memberType, String memerClass, String productType, Date inDate,String status) ;

    public ProgramRule findByRuleId(Integer ruleId);
    
    public List<ProgramRule> findAll();
    
    public List<ProgramRule> findByProgramId(String programId);
    
    public boolean findDuplicate(String memberType,String memberClass, String productType, Date startDate,String status);
   
}
