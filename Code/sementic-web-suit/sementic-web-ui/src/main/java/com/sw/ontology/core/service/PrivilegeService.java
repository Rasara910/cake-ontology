/**
 * 
 */
package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.model.Privilege;


/**
 * @author kithmal
 * 
 */
public interface PrivilegeService {
  
  public List<Privilege> findAll();
  
  public Privilege findByPrivilegeName(String privilegeName);
  
    public List<Privilege> findByRoles(String roleName);
}
