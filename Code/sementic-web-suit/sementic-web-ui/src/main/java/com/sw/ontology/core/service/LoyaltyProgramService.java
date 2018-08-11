/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.LoyaltyProgram;
import com.sw.ontology.model.ProgramRule;
import java.util.List;

/**
 *
 * @author Amith
 */
public interface LoyaltyProgramService {
    
    public void save(LoyaltyProgram loyaltyProgram,List<ProgramRule> programRules)throws SystemException;
    
    public LoyaltyProgram findbyProgramId(String programId);
    
    public List<LoyaltyProgram> findAll();
    
    public List<LoyaltyProgram> findLike(String programId,String programName,String programType);

}
