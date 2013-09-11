/* --------------------------------------------------------------------
Copyright (C) 2013 - Pablo Belay Fernández 
This program is free software: you can redistribute it
and/or modify it under the terms of the GNU General
Public License as published by the Free Software
Foundation, either version 3 of the License, or (at your
option) any later version.
This program is distributed in the hope that it will be
useful, but WITHOUT ANY WARRANTY; without even the
implied warranty of MERCHANTABILITY or FITNESS FOR A
PARTICULAR PURPOSE. See the GNU General Public License
for more details.
You should have received a copy of the GNU General Public
License along with this program. If not, see
http://www.gnu.org/licenses/gpl-3.0-standalone.html
--------------------------------------------------------------------*/
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
		
		@SuppressWarnings("unchecked")
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
		
		@SuppressWarnings("unchecked")
		List<Usuario> saida = em.createQuery(queryStri).setParameter("login", login).getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
	}
	
	

	@SuppressWarnings("unchecked")
	public List<Usuario> lista (){
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u " +
				         " ORDER by u.login ASC" ;

		List<Usuario> saida = em.createQuery(queryStri).getResultList();
		
		return saida;
	}

	public List<Usuario> findPatronsDunArmador(long idArmador) {
		
		EntityManager em = JPAUtil.createEntityManager();
		
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u  " +
						 " WHERE (u.patron_autoriza = :patron_autoriza)";
		
		@SuppressWarnings("unchecked")
		List<Usuario> saida = em.createQuery(queryStri).setParameter("patron_autoriza", idArmador).getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
		
	}

	public List<Usuario> findPatronsDunArmador(long idArmador, String login) {
		
		EntityManager em = JPAUtil.createEntityManager();
		
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u  " +
						 " WHERE (u.patron_autoriza = :patron_autoriza) " +
						 " AND ( u.login like :login) ";
		
		@SuppressWarnings("unchecked")
		List<Usuario> saida = em.createQuery(queryStri).setParameter("patron_autoriza", idArmador).setParameter("login", "%"+login+"%").getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
	}
	
	
public List<Usuario> findPatronDunArmador(long idArmador, long id) {
		
		EntityManager em = JPAUtil.createEntityManager();
		
		em.getTransaction().begin();
		String queryStri=" FROM Usuario u  " +
						 " WHERE (u.patron_autoriza = :patron_autoriza) " +
						 " AND ( u.id like = :id) ";
		
		@SuppressWarnings("unchecked")
		List<Usuario> saida = em.createQuery(queryStri).setParameter("patron_autoriza", idArmador).setParameter("id", id).getResultList();
		
		
		if (null == saida ||saida.isEmpty() ){
			return null;
		}else{
		   return saida;
		}
		
	}
	
	

}

