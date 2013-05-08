package com.xeopesca.webapp.model.dao;

import java.util.List;
import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Faena;


public class FaenaDAO extends GenericDaoHibernate<Faena>{

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
