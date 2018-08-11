/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.model.MemberType;

/**
 *
 * @author Amith
 */
public interface MemberTypeService {
    
    public MemberType findByMemberType(String type);
    
    public List<MemberType> findAll();
    
    public void save(MemberType memberType) throws Exception;
}
