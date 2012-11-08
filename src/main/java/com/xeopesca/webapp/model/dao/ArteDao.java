package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Arte;


public class ArteDAO extends GenericDaoHibernate<Arte>{

	@SuppressWarnings("unchecked")
	public List<Arte> lista() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Arte a " 
						 + " ORDER by a.nome  ASC";
		List<Arte> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	public List<Arte> finByArte(String nome) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Arte a  " +
						" WHERE (a.nome like :nome)";
		
		List<Arte> saida = em.createQuery(queryStri).setParameter("nome", nome).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Arte>();
		}
		
		return saida;
	}

}
