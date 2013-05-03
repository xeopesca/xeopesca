package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Barco;

public class BarcoDAO  extends GenericDaoHibernate<Barco>
{

	
	@SuppressWarnings("unchecked")
	public List<Barco> fingByFolio(String folio, long idarmador ) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e  " +
						" WHERE (e.folio like :folio) " +
						" AND e.idarmador = :idarmador ";
		
		List<Barco> saida = em.createQuery(queryStri).setParameter("folio", folio).setParameter("idarmador", idarmador).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Barco>();
		}
		
		return saida;
	}
	

	@SuppressWarnings("unchecked")
	public List<Barco> buscarBarcoArmador(long id, long idarmador ) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e  " +
						" WHERE (e.id = :id) " +
						" AND e.idarmador = :idarmador ";
		
		List<Barco> saida = em.createQuery(queryStri).setParameter("id", id).setParameter("idarmador", idarmador).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Barco>();
		}
		
		return saida;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Barco> lista (){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e " +
				         " ORDER by e.folio  ASC" ;

		List<Barco> saida = em.createQuery(queryStri).getResultList();
		
			return saida;
	}


	public List<Barco> fingByIdArmador(long idarmador) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e " +
						 " WHERE e.idarmador = :idarmador " +
				         " ORDER by e.folio  ASC" ;

		@SuppressWarnings("unchecked")
		List<Barco> saida = em.createQuery(queryStri).setParameter("idarmador", idarmador).getResultList();
		
			return saida;
			
	}
	
	public List<Barco> fingById(long id) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e " +
						 " WHERE e.id = :id " +
				         " ORDER by e.folio  ASC" ;

		@SuppressWarnings("unchecked")
		List<Barco> saida = em.createQuery(queryStri).setParameter("id", id).getResultList();
		
			return saida;
	}
	
	
	

}

