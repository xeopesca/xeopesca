package com.xeopesca.webapp.model.dao;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Evento;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Karel Maesen, Geovise BVBA creation-date: 6/19/12
 */
public class EventoDAO extends GenericDaoHibernate<Evento> {


/*
	public void save(Evento theEvent) {

		
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();

		em.persist(theEvent);

		em.getTransaction().commit();
		em.close();
	}
*/
	private Geometry wktToGeometry(String wktPoint) {
		WKTReader fromText = new WKTReader();
		Geometry geom = null;
		try {
			geom = fromText.read(wktPoint);
		} catch (ParseException e) {
			throw new RuntimeException("Not a WKT string:" + wktPoint);
		}
		return geom;
	}
/*
	public List find(String wktFilter) {
		Geometry filter = wktToGeometry(wktFilter);
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery(
						"select e from Evento e where within(e.location, :filter) = true",
						Evento.class);
		query.setParameter("filter", filter);
		return query.getResultList();
	}
*/
	public List findAll() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Evento ", Evento.class);

		return query.getResultList();
	}

	public long countAll(Map<String, Object> params) {
		// TODO Auto-generated method stub
		return 0;
	}


}
