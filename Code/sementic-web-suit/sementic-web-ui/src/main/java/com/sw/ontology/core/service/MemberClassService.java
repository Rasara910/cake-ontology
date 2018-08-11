package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import java.util.List;

import com.sw.ontology.model.MemberClass;

/**
 *
 * @author Umaya
 *
 */
public interface MemberClassService {

    public MemberClass findByMemberClass(String memberClass);

    public List<MemberClass> findLikeMemberClass(String memberClass);

    public List<MemberClass> findAll();

    public void save(MemberClass memberClas) throws SystemException;

    public void update(MemberClass memberClass) throws SystemException;

}
