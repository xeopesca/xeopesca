package com.xeopesca.tutorial.event;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.xeopesca.tutorial.*;
import com.xeopesca.tutorial.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * @author Karel Maesen, Geovise BVBA creation-date: 6/19/12
 */
public class EventManager {



	public void createAndStoreEvent(String title, Date theDate, String wktPoint) {
		Geometry geom = wktToGeometry(wktPoint);

		if (!geom.getGeometryType().equals("Point")) {
			throw new RuntimeException("Geometry must be a point. Got a "
					+ geom.getGeometryType());
		}

		EntityManager em = JPAUtil.createEntityManager();

		em.getTransaction().begin();

		Event theEvent = new Event();

		theEvent.setTitle(title);
		theEvent.setDate(theDate);
		theEvent.setLocation((Point) geom);
		em.persist(theEvent);

		em.getTransaction().commit();
		em.close();
	}

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

	public List find(String wktFilter) {
		Geometry filter = wktToGeometry(wktFilter);
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em
				.createQuery(
						"select e from Event e where within(e.location, :filter) = true",
						Event.class);
		query.setParameter("filter", filter);
		return query.getResultList();
	}

	public List findAll() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Event ", Event.class);

		return query.getResultList();
	}


}
