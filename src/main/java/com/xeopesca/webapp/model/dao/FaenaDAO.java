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

import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Faena;

/**
 * @author belay
 * 
 */
public class FaenaDAO extends GenericDaoHibernate<Faena> {

	/**
	 * Recupera as faenas asociadas a un barco a través de hql
	 * 
	 * @param long idbarco
	 * @return List<Faena>
	 * **/
	@SuppressWarnings("unchecked")
	public List<Faena> lista(long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM  Faena f " + " WHERE (f.idBarco = :idBarco) "
				+ " ORDER by f.id  ASC";
		List<Faena> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	/**
	 * Recupera as faenas asociadas a un barco a través de hql
	 * 
	 * @param long idbarco
	 * @return List<Faena>
	 * **/
	public List<Faena> faenasBarco(Long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Faena f " + " WHERE (f.idbarco = :idbarco) "
				+ " ORDER by f.id  DESC ";

		@SuppressWarnings("unchecked")
		List<Faena> saida = em.createQuery(queryStri)
				.setParameter("idbarco", idBarco).getResultList();

		return saida;
	}

	/**
	 * Buscador avanzado, buscamos polos diferentes campos duha faena
	 * 
	 * @param Faena
	 *            faena
	 * @return List<Faena>
	 * */
	public List<Faena> faenasBuscador(Faena faena) {
		EntityManager em = JPAUtil.createEntityManager();
		CriteriaBuilder cb = em.getEntityManagerFactory().getCriteriaBuilder();

		CriteriaQuery<Faena> criteriaQuery = cb.createQuery(Faena.class);

		// Indicamos la entidad sobre la cual necesitamos crear la consulta
		Root<Faena> faenaER = criteriaQuery.from(Faena.class);
		// Creamos un predicado conjunction, que vienen a ser un tipo de
		// restriccion en el query
		Predicate conjunction = cb.conjunction();

		/**
		 * APLICAMOS OS FILTROS DA BUSQUEDA
		 * 
		 * **/

		// agregamos una expresion al conjunction, greater than
		if (faena.getIdbarco() != 0) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("idbarco").as(Integer.class),
							faena.getIdbarco()));
		}

		if (faena.getIdarte() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("idarte").as(Integer.class),
							faena.getIdarte()));
		}
		if (faena.getEstado_ceo() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("estado_ceo").as(Integer.class),
							faena.getEstado_ceo()));
		}

		if (faena.getEstado_mar() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("estado_mar").as(Integer.class),
							faena.getEstado_mar()));
		}

		if (faena.getLua() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("lua").as(Integer.class),
							faena.getLua()));
		}

		if (faena.getDireccion_vento() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("direccion_vento").as(Integer.class),
							faena.getDireccion_vento()));
		}
		// Entre estas datas de incio
		if (faena.getData_inicio() != null) {
			Predicate predicado = cb.greaterThanOrEqualTo(
					faenaER.get("data_inicio").as(Date.class),
					faena.getData_inicio());
			conjunction.getExpressions().add(predicado);

		}
		if (faena.getData_fin() != null) {
			Predicate predicado2 = cb.lessThanOrEqualTo(
					faenaER.get("data_inicio").as(Date.class),
					faena.getData_fin());
			conjunction.getExpressions().add(predicado2);
		}

		// si el conjunction posee mas de cero expresiones, entonces las
		// agregamos al query con el metodo where
		// SpatialRestrictions.

		if (conjunction.getExpressions().size() > 0) {
			criteriaQuery.where(conjunction);
		}

		// retornamos una lista de la entidad especificada
		List<Faena> saida = em.createQuery(criteriaQuery).getResultList();

		return saida;

	}

	/**
	 * Buscador avanzado, buscamos polos diferentes campos duha faena
	 * 
	 * @param Faena
	 *            faena
	 * @return List<Faena>
	 * */
	public List<Faena> faenasBuscador(Faena faena, String barcos) {
		EntityManager em = JPAUtil.createEntityManager();
		CriteriaBuilder cb = em.getEntityManagerFactory().getCriteriaBuilder();

		CriteriaQuery<Faena> criteriaQuery = cb.createQuery(Faena.class);

		// Indicamos la entidad sobre la cual necesitamos crear la consulta
		Root<Faena> faenaER = criteriaQuery.from(Faena.class);
		// Creamos un predicado conjunction, que vienen a ser un tipo de
		// restriccion en el query
		Predicate conjunction = cb.conjunction();

		/**
		 * APLICAMOS OS FILTROS DA BUSQUEDA
		 * 
		 * **/

		// agregamos una expresion al conjunction, greater than
		if (faena.getIdbarco() != 0) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("idbarco").as(Integer.class),
							faena.getIdbarco()));
		}

		if (faena.getIdarte() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("idarte").as(Integer.class),
							faena.getIdarte()));
		}
		if (faena.getEstado_ceo() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("estado_ceo").as(Integer.class),
							faena.getEstado_ceo()));
		}

		if (faena.getEstado_mar() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("estado_mar").as(Integer.class),
							faena.getEstado_mar()));
		}

		if (faena.getLua() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("lua").as(Integer.class),
							faena.getLua()));
		}

		if (faena.getDireccion_vento() != null) {
			conjunction.getExpressions().add(
					cb.equal(faenaER.get("direccion_vento").as(Integer.class),
							faena.getDireccion_vento()));
		}
		// Entre estas datas de incio
		if (faena.getData_inicio() != null) {
			Predicate predicado = cb.greaterThanOrEqualTo(
					faenaER.get("data_inicio").as(Date.class),
					faena.getData_inicio());
			conjunction.getExpressions().add(predicado);

		}
		if (faena.getData_fin() != null) {
			Predicate predicado2 = cb.lessThanOrEqualTo(
					faenaER.get("data_inicio").as(Date.class),
					faena.getData_fin());
			conjunction.getExpressions().add(predicado2);
		}

		// si el conjunction posee mas de cero expresiones, entonces las
		// agregamos al query con el metodo where
		// SpatialRestrictions.

		if (conjunction.getExpressions().size() > 0) {
			criteriaQuery.where(conjunction);
		}

		// retornamos una lista de la entidad especificada
		List<Faena> saida = em.createQuery(criteriaQuery).getResultList();

		return saida;

	}

}
