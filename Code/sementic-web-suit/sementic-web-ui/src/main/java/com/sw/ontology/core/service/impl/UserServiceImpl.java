/*
 * //
 * *************************************************************************************************
 * // // PROJECT : Nation Trust bank // PRODUCT : Lead Management System - Core //
 * ************************************************************************************************
 * // // Copyright(C) 2014 Fortunaglobal (PRIVATE) LIMITED // All rights reserved. // // THIS IS
 * UNPUBLISHED PROPRIETARY SOURCE CODE OF // Fortunaglobal(PRIVATE) LIMITED. // // This copy of the
 * Source Code is intended for Fortunaglobal (PRIVATE) LIMITED 's internal use only // and is //
 * intended for view by persons duly authorized by the management of Fortunaglobal (PRIVATE) //
 * LIMITED. No // part of this file may be reproduced or distributed in any form or by any // means
 * without the written approval of the Management of Fortunaglobal (PRIVATE) LIMITED. // //
 * *************************************************************************************************
 * // // REVISIONS: // Author : Amith // Date : Nov 17, 2014, 4:14:38 PM // Since : Version 1.0 //
 * Description : UserServiceImpl
 */
package com.sw.ontology.core.service.impl;

import java.util.Date;
import java.util.List;

import com.sw.ontology.core.dao.UserDao;
import com.sw.ontology.core.service.PrivilegeService;
import com.sw.ontology.core.service.RoleService;
import com.sw.ontology.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sw.ontology.core.exception.SystemException;
import com.sw.ontology.model.Privilege;
import com.sw.ontology.model.User;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Amith
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PrivilegeService privilegeService;

    @Transactional
    @Override
    public void save(User user, String userName) throws SystemException {
        try {
            user.setModifiedBy(userName);
            user.setModifiedDate(new Date());
            userDao.create(user);
        } catch (Exception e) {
            logger.error("error occured in save()", e);
            throw new SystemException("Error", e);
        }

    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User findByUserName(String username) throws SystemException {
        User object = userDao.read(username);
        if (object == null) {
            logger.info("No User found for " + username);
            throw new SystemException("User not found");
        }

        return object;
    }

    @Transactional
    @Override
    public void update(User user) throws SystemException {
        try {
            userDao.update(user);
        } catch (Exception e) {
            logger.error("error occured in update()", e);
            throw new SystemException("Error", e);
        }

    }

    @Transactional
    @Override
    public void updateUserPassword(User user) throws SystemException {
        try {
            userDao.update(user);
        } catch (Exception e) {
            logger.error("error occured in update()", e);
            throw new SystemException("error", e);
        }
    }


    @Override
    public User initSystemUser(String username) throws SystemException {
        try {
            User user = findByUserName(username);
            List<Privilege> findByRoles = privilegeService.findByRoles(user.getRoleName().getRoleName());
            user.setPrivileges(findByRoles);
            return user;
        } catch (Exception e) {
            logger.error("error occured in initSystemUser()", e);
            throw new SystemException("error", e);
        }
    }

    @Override
    public List<User> findByRoleName(String roleName) {
        String sql = "SELECT a FROM User a WHERE a.roleName.roleName=:roleName ";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("roleName", roleName);
        return userDao.findbyQuery(sql, params);
    }

    @Transactional
    @Override
    public void updateToken(User user, String token) {
        user.setResetToken(token);
        userDao.update(user);
    }

}
