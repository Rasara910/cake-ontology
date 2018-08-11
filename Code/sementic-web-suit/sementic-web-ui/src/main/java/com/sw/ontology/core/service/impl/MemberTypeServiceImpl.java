/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service.impl;

import java.util.List;

import com.sw.ontology.core.dao.MemberTypeDao;
import com.sw.ontology.core.service.MemberTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.model.MemberType;

/**
 *
 * @author Amith
 */
@Service
public class MemberTypeServiceImpl implements MemberTypeService {

    @Autowired
    private MemberTypeDao memberTypeDao;

    @Override
    public MemberType findByMemberType(String type) {
        return memberTypeDao.read(type);
    }

    @Override
    public List<MemberType> findAll() {
        return memberTypeDao.findAll();
    }

    @Transactional
    @Override
    public void save(MemberType memberType) throws Exception {
        memberTypeDao.create(memberType);
    }

}
