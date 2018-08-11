/*
 // *************************************************************************************************
 //
 // PROJECT : AOD School Management System
 // PRODUCT : School Management System
 // CLASS : 
 // PURPOSE : 
 // ************************************************************************************************
 //
 // Copyright(C) 2013 Fortunaglobal (PRIVATE) LIMITED
 // All rights reserved.
 //
 // THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE OF
 // Fortunaglobal(PRIVATE) LIMITED.
 //
 // This copy of the Source Code is intended for Fortunaglobal (PRIVATE) LIMITED 's internal use only
 // and is
 // intended for view by persons duly authorized by the management of Fortunaglobal (PRIVATE)
 // LIMITED. No
 // part of this file may be reproduced or distributed in any form or by any
 // means without the written approval of the Management of Fortunaglobal (PRIVATE) LIMITED.
 // *************************************************************************************************
 */
package com.sw.ontology.core.dao.impl;


import com.sw.ontology.core.dao.IDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author Amith Fernando
 * @param <T>
 * @param <PK>
 */
public abstract class DaoImpl<T, PK extends Serializable> implements IDao<T, PK> {

    /* Persistence Entity class type. */
    protected Class<T> entityClass;

    /* Entity manager to perform DAO operations. */
    @PersistenceContext
    protected EntityManager entityManager;

    /**
     * Constructor
     */
    @SuppressWarnings("unchecked")
    public DaoImpl() {

        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
    }

    @Override
	public T create(T t) {

        this.entityManager.persist(t);
        return t;
    }

    @Override
    public T read(PK id) {
        return this.entityManager.find(entityClass, id);
    }

    @Override
    public T update(T t) {

        return this.entityManager.merge(t);
    }

    public void delete(T t) {

        t = this.entityManager.merge(t);
        this.entityManager.remove(t);
    }

    @Override
    public List<T> findAll() {
        Query query = entityManager.createQuery("FROM " + entityClass.getName() + " c");
        return (List<T>) query.getResultList();
    }

    @Override
    public List<T> findNamedQuery(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createNamedQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();
    }

    @Override
    public List<T> findNamedQueryLimit(String query, Map<String, Object> params, int limit) {
        javax.persistence.Query q = this.entityManager.createNamedQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<T> findbyQueryLimit(String query, Map<String, Object> params, int limit) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        q.setMaxResults(limit);
        return q.getResultList();
    }

    @Override
    public List<T> findbyQuery(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        return q.getResultList();
    }

    @Override
    public T findbyQuerySingle(String query, Map<String, Object> params) {
        javax.persistence.Query q = this.entityManager.createQuery(query);
        for (Map.Entry<String, Object> en : params.entrySet()) {
            String object = en.getKey();
            Object value = en.getValue();
            q.setParameter(object, value);
        }
        try {
            return (T) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

    @Override
    public T findSingleNamedQuery(String query, Map<String, Object> params) {
        try {
            javax.persistence.Query q = this.entityManager.createNamedQuery(query);
            for (Map.Entry<String, Object> en : params.entrySet()) {
                String object = en.getKey();
                Object value = en.getValue();
                q.setParameter(object, value);
            }
            return (T) q.getSingleResult();
        } catch (javax.persistence.NoResultException e) {
            return null;
        }
    }

}
