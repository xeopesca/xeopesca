package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Especie;

public class EspecieDAO  extends GenericDaoHibernate<Especie>
{

	
	@SuppressWarnings("unchecked")
	public List<Especie> finByEspecie(String nome) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Especie e  " +
						" WHERE (e.nomecientifico like :nome)";
		
		List<Especie> saida = em.createQuery(queryStri).setParameter("nome", nome).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Especie>();
		}
		
		return saida;
	}
	

	@SuppressWarnings("unchecked")
	public List<Especie> lista (){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Especie e " +
				         " ORDER by e.nomecientifico  ASC" ;

		List<Especie> saida = em.createQuery(queryStri).getResultList();
		
			return saida;
	}
	
	
	

}

