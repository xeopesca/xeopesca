/* --------------------------------------------------------------------
 This file is part of xeoPesca

Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/
package com.xeopesca.util.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.xeopesca.util.JPAUtil;

/**
 * @author belay
 *
 * @param <T>
 */

public abstract class GenericDaoHibernate<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    /**
     * Constructor
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoHibernate() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        em = JPAUtil.createEntityManager();
    }


    
    /* (non-Javadoc)
     * @see com.xeopesca.util.dao.GenericDao#create(java.lang.Object)
     */
    public T create(final T t) {
    	em = JPAUtil.createEntityManager();
    	em.getTransaction().begin();
    	
        this.em.persist(t);
        
        em.getTransaction().commit();
		em.close();
        return t;
    }

    /* (non-Javadoc)
     * @see com.xeopesca.util.dao.GenericDao#delete(java.lang.Object)
     */
    public void delete(final Object id) {
    	em = JPAUtil.createEntityManager();
    	em.getTransaction().begin();
    	
        this.em.remove(this.em.getReference(type, id));
        
        em.getTransaction().commit();
      		em.close();
    }

    /* (non-Javadoc)
     * @see com.xeopesca.util.dao.GenericDao#find(java.lang.Object)
     */
    public T find(final Object id) {
        return (T) this.em.find(type, id);
    }

    public T update(final T t) {
    	
    	this.em = JPAUtil.createEntityManager();
    	this.em.getTransaction().begin();
    	T obxecto = this.em.merge(t);
    	
    	//this.em.refresh(obxecto);
    	this.em.getTransaction().commit();
      	this.em.close();
    	return obxecto ;
    }
}