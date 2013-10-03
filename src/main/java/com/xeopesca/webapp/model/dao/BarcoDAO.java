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

