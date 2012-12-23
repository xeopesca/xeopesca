package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Barco;
import com.xeopesca.webapp.model.vos.Especie;

public class BarcoDAO  extends GenericDaoHibernate<Barco>
{

	
	@SuppressWarnings("unchecked")
	public List<Barco> fingByFolio(String folio) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Barco e  " +
						" WHERE (e.folio like :folio)";
		
		List<Barco> saida = em.createQuery(queryStri).setParameter("folio", folio).getResultList();
		
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
	
	
	

}

