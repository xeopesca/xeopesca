package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Faena;


public class FaenaDAO extends GenericDaoHibernate<Faena>{

	public List<Faena> buscadorAvanzado(long idBarco){
		List<Faena> saida = new ArrayList<Faena>();
		EntityManager em = JPAUtil.createEntityManager();		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		return saida;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Faena> lista(long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM  Faena f " +
				           " WHERE (f.idBarco = :idBarco) " 
						 + " ORDER by f.id  ASC";
		List<Faena> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	public  List<Faena> faenasBarco(Long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Faena f " +
						   " WHERE (f.idbarco = :idbarco) " 
						 + " ORDER by f.id  DESC ";

		@SuppressWarnings("unchecked")
		List<Faena> saida = em.createQuery(queryStri).setParameter("idbarco", idBarco).getResultList();
		
		return saida;
	}

}
