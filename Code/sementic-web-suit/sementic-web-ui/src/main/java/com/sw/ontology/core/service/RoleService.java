/**
 * 
 */
package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.model.Privilege;
import com.sw.ontology.model.Role;

/**
 * Created by praveen on 8/12/18
 */

public interface RoleService {
  
//  public void save(Role role, List<Privilege> privileges);
  
  public Role findByRoleName(String roleName) throws Exception;
  
  public List<Role> findAll() throws Exception;
}
