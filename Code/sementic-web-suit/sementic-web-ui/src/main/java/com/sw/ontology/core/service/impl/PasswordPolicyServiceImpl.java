package com.sw.ontology.core.service.impl;

import java.util.List;

import com.sw.ontology.core.dao.PasswordPolicyDao;
import com.sw.ontology.core.dao.impl.DaoImpl;
import com.sw.ontology.core.service.PasswordPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.ontology.model.PasswordPolicy;

@Service
public class PasswordPolicyServiceImpl extends DaoImpl<PasswordPolicy, String> implements PasswordPolicyService {
	
	@Autowired
	private PasswordPolicyDao passwordPolicyDao;

	@Override
	public PasswordPolicy findById(Integer id) {
		return passwordPolicyDao.read(id);
	}
	
	@Override
	public List<PasswordPolicy> findAll() {
		return passwordPolicyDao.findAll();
	}
	
}
