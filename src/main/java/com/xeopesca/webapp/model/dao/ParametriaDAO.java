package com.xeopesca.webapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Parametria;

/**
 * @author belay
 *
 */
public class ParametriaDAO  extends GenericDaoHibernate<Parametria>
{

	
	
	
	/**
	 * Recupera un parametro
	 * @param parametro
	 * @return Lista de parametros asociados a esa clave
	 */
	public List<Parametria> findParametria(String parametro) {
		
		
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Parametria u  " +
						" WHERE (u.parametro like :parametro) " +
						" ORDER BY u.literal  DESC";
		
		
		@SuppressWarnings("unchecked")
		List<Parametria> saida = em.createQuery(queryStri).setParameter("parametro", parametro).getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
	}
	
	

	

}

