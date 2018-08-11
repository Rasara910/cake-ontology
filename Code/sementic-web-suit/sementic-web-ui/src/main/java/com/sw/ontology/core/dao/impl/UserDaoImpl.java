/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sw.ontology.core.dao.impl;

import com.sw.ontology.core.dao.UserDao;
import com.sw.ontology.model.User;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Amith
 */
@Repository
public class UserDaoImpl extends DaoImpl<User, String> implements UserDao {

}
