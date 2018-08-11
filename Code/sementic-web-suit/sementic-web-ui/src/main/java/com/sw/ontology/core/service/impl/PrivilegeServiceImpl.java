/**
 *
 */
package com.sw.ontology.core.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.sw.ontology.core.dao.PrivilegeDao;
import com.sw.ontology.core.dao.RolePrivilegeDao;
import com.sw.ontology.core.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sw.ontology.model.Privilege;
import com.sw.ontology.model.RolePrivilege;

/**
 * @author kithmal
 *
 */
@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    private PrivilegeDao privilegeDao;

    @Autowired
    private RolePrivilegeDao rolePrivilegeDao;

    private final static Logger LOGGER = Logger.getLogger(PrivilegeServiceImpl.class.getName());

    @Override
    public List<Privilege> findAll() {

        return privilegeDao.findAll();
    }

    @Override
    public Privilege findByPrivilegeName(String privilegeName) {

        return privilegeDao.read(privilegeName);
    }

    @Override
    public List<Privilege> findByRoles(String roleName) {

        List<Privilege> privileges = new ArrayList<>();
        String sql = "SELECT a FROM RolePrivilege a WHERE a.rolePrivilegePK.roleName = :role";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("role", roleName);
        List<RolePrivilege> rolePrivileges = rolePrivilegeDao.findbyQuery(sql, params);
        for (RolePrivilege rolePrivilege : rolePrivileges) {
            Privilege privilege = privilegeDao.read(rolePrivilege.getRolePrivilegePK().getPrivilegeCode());
            privileges.add(privilege);
        }

        return privileges;
    }

}
