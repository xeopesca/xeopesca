/* --------------------------------------------------------------------
 This file is part of xeoPesca

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

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Arte;


/**
 * @author belay
 *
 */
public class ArteDAO extends GenericDaoHibernate<Arte>{

	/**
	 * Recupera todas as artes existentes no sistema.
	 * @return List<Arte>
	 * */
	@SuppressWarnings("unchecked")
	public List<Arte> lista() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Arte a " 
						 + " ORDER by a.nome  ASC";
		List<Arte> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	/**
	 * Busca unha arte polo seu nome
	 * @param String nome
	 * @return List<Arte>
	 * */
	public List<Arte> finByArte(String nome) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri=" FROM Arte a  " +
						" WHERE (a.nome like :nome)";
		
		@SuppressWarnings("unchecked")
		List<Arte> saida = em.createQuery(queryStri).setParameter("nome", nome).getResultList();
		
		if (null==saida || saida.isEmpty()){
			saida = new ArrayList<Arte>();
		}
		
		return saida;
	}

}
