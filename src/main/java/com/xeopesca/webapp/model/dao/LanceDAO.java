package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Lance;


public class LanceDAO extends GenericDaoHibernate<Lance>{

	@SuppressWarnings("unchecked")
	public List<Lance> lista() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM lance l " 
						 + " ORDER by l.id  ASC";
		List<Lance> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	

}
