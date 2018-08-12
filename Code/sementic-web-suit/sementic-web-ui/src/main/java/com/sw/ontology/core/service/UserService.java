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
 * // // REVISIONS: // Author : Amith // Date : Nov 17, 2014, 4:13:25 PM // Since : Version 1.0 //
 * Description : UserService
 */
package com.sw.ontology.core.service;

import com.sw.ontology.core.exception.SystemException;
import java.util.List;

import com.sw.ontology.model.User;

/**
 * Created by praveen on 8/12/18
 */

public interface UserService {

    public void save(User user, String userName) throws SystemException;

    public void update(User user) throws SystemException;

    public void updateUserPassword(User user) throws SystemException;

    public List<User> findAll();

    public User findByUserName(String employeeId) throws SystemException;

    
    public List<User> findByRoleName(String roleName) ;

	public void updateToken(User user, String token);

}
