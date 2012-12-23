package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Nomepopular;


public class NomepopularDAO extends GenericDaoHibernate<Nomepopular>{

	@SuppressWarnings("unchecked")
	public List<Nomepopular> lista() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Nomepopular a " 
						 + " ORDER by a.nome  ASC";
		List<Nomepopular> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	@SuppressWarnings("unchecked")
	public List<Nomepopular> findByNome(String nome) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Nomepopular a  " +
						" WHERE (a.nome  like :nome)" 
					   +" ORDER by a.nome  ASC";
		
		List<Nomepopular> saida = em.createQuery(queryStri).setParameter("nome", nome).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Nomepopular>();
		}
		
		return saida;
	}

}
