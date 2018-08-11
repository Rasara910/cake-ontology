/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import java.util.List;

import com.sw.ontology.model.MemberMaster;

/**
 *
 * @author Amith
 */
public interface MemberMasterService {

    public void save(MemberMaster memberMaster) throws SystemException;

    public void update(MemberMaster memberMaster) throws SystemException;

    public MemberMaster findByMemberCode(String code);

    public MemberMaster findByMobileNo(String mobileNo);

    public List<MemberMaster> findLikeMobileNo(String mobileNo);

    public List<MemberMaster> findLikeMemberCode(String memberCode);

    public List<MemberMaster> findAll();

    public List<MemberMaster> findLike(String name, String code, String nic, String contatNo);
}
