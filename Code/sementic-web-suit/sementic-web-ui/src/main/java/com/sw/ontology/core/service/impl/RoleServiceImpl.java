/**
 *
 */
package com.sw.ontology.core.service.impl;

import java.util.List;
import java.util.logging.Logger;

import com.sw.ontology.core.dao.RoleDao;
import com.sw.ontology.core.dao.RolePrivilegeDao;
import com.sw.ontology.core.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.core.exception.ValidationException;
import com.sw.ontology.model.Privilege;
import com.sw.ontology.model.Role;
import com.sw.ontology.model.RolePrivilege;
import com.sw.ontology.model.enums.GeneralStatus;

/**
 * @author kithmal
 * 
 */
@Service
public class RoleServiceImpl implements RoleService {
  
  @Autowired
  private RoleDao roleDao;
  
  @Autowired
  private RolePrivilegeDao rolePrivilegeDao;
  
  private final static Logger LOGGER = Logger.getLogger(RoleServiceImpl.class.getName());
  
  @Transactional
  @Override
  public void save(Role role, List<Privilege> privileges) {
  
    try {
        roleDao.create(role);
        for (Privilege privilege : privileges) {
          RolePrivilege rolePrivilege = new RolePrivilege(privilege.getPrivilegeName(), role.getRoleName());
          rolePrivilege.setStatus(GeneralStatus.ACTIVE);
          rolePrivilegeDao.create(rolePrivilege);
        }
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  @Override
  public Role findByRoleName(String roleName) throws Exception {
  
    Role role = roleDao.read(roleName);
    if (role == null) {
      throw new ValidationException("Role Not Found");
    }
    
    return role;
  }
  
  @Override
  public List<Role> findAll() throws Exception {
    return roleDao.findAll();
  }
  
}
