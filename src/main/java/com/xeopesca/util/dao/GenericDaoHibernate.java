package com.xeopesca.util.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;



import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import com.xeopesca.util.JPAUtil;

public abstract class GenericDaoHibernate<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager em;

    private Class<T> type;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public GenericDaoHibernate() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        type = (Class) pt.getActualTypeArguments()[0];
        em = JPAUtil.createEntityManager();
    }


    public T create(final T t) {
    	em = JPAUtil.createEntityManager();
    	em.getTransaction().begin();
    	
        this.em.persist(t);
        
        em.getTransaction().commit();
		em.close();
        return t;
    }

    public void delete(final Object id) {
    	em = JPAUtil.createEntityManager();
    	em.getTransaction().begin();
    	
        this.em.remove(this.em.getReference(type, id));
        
        em.getTransaction().commit();
      		em.close();
    }

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