package com.sw.ontology.core.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sw.ontology.core.dao.MemberClassDao;
import com.sw.ontology.core.service.MemberClassService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.MemberClass;

/**
 *
 * @author Umaya
 *
 */
@Service
public class MemberClassServiceImpl implements MemberClassService {

    private final Logger logger = LoggerFactory.getLogger(MemberClassServiceImpl.class);

    @Autowired
    private MemberClassDao memberClassDao;

    @Override
    public MemberClass findByMemberClass(String memberClass) {
        return memberClassDao.read(memberClass);
    }

    @Override
    public List<MemberClass> findAll() {
        return memberClassDao.findAll();
    }

    @Override
    @Transactional
    public void save(MemberClass memberClass) throws SystemException {
        try {
            memberClassDao.create(memberClass);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new SystemException("ERROR", e);
        }

    }

    @Override
    @Transactional
    public void update(MemberClass memberClass) throws SystemException {
        try {
            memberClassDao.update(memberClass);
        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new SystemException("ERROR", e);
        }

    }

    @Override
    public List<MemberClass> findLikeMemberClass(String memberClass) {
        String sql = "SELECT a FROM MemberClass a WHERE a.memberClass LIKE :memberClass  ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("memberClass", "%" + memberClass + "%");
        return memberClassDao.findbyQuery(sql, params);
    }

}
