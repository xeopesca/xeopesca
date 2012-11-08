package com.xeopesca.webapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Usuario;

public class UsuarioDAO  extends GenericDaoHibernate<Usuario>
{

	
	public Usuario finByLogin(String login) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u  " +
						" WHERE (u.login like :login)";
		
		List<Usuario> saida = em.createQuery(queryStri).setParameter("login", login).getResultList();
		
		
		if (saida.isEmpty()){
			return null;
		}else{
		   return (Usuario) saida.get(0);
		}
		
	}
	
	public List<Usuario> finBySimilarLogin(String login) {
		login = "%"+login+"%";
		
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u  " +
						" WHERE (u.login like :login)";
		
		List<Usuario> saida = em.createQuery(queryStri).setParameter("login", login).getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
	}
	
	

	public List<Usuario> lista (){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u " +
				         " ORDER by u.login ASC" ;

		List<Usuario> saida = em.createQuery(queryStri).getResultList();
		
		return saida;
	}
	
	
	

}

