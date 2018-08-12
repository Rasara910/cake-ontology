/**
 * 
 */
package com.sw.ontology.core.service;

import java.util.List;

import com.sw.ontology.model.Privilege;


/**
 * Created by praveen on 8/12/18
 */

public interface PrivilegeService {
  
  public List<Privilege> findAll();
  
  public Privilege findByPrivilegeName(String privilegeName);
  

}
