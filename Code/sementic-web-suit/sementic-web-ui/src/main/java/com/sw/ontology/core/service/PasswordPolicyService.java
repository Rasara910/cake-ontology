package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.core.dao.IDao;
import com.sw.ontology.model.PasswordPolicy;
/**
 * Created by praveen on 8/12/18
 */

public interface PasswordPolicyService extends IDao<PasswordPolicy, String> {
	public PasswordPolicy findById(Integer id);
	public List<PasswordPolicy> findAll();
}
