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

	public static void main(String[] args) {
		EventManager mgr = new EventManager();

		// args = "store POINT(10 5)".split(" ");

		args = "find POLYGON((1\\ 1,20\\ 1,20\\ 20,1\\ 20,1\\ 1)) ".split(" ");

		if (args.length != 0) {
			if (args[0].equals("store")) {
				mgr.createAndStoreEvent("My Event", new Date(), assemble(args));
			} else if (args[0].equals("find")) {
				List events = mgr.find(args[1]);
				for (int i = 0; i < events.size(); i++) {
					Event event = (Event) events.get(i);
					System.out.println("Event: " + event.getTitle()
							+ ", Time: " + event.getDate() + ", Location: "
							+ event.getLocation());
				}
			}

			JPAUtil.close();
		}

		/*
		 * List events = mgr.findAll(); for (int i = 0; i < events.size(); i++)
		 * { Event event = (Event) events.get(i); System.out.println("Event: " +
		 * event.getTitle() + ", Time: " + event.getDate() + ", Location: " +
		 * event.getLocation()); }
		 */

	}

	private void createAndStoreEvent(String title, Date theDate, String wktPoint) {
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

	private List find(String wktFilter) {
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

	private List findAll() {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Event ", Event.class);

		return query.getResultList();
	}

	/**
	 * Utility method to assemble all arguments save the first into a String
	 */
	private static String assemble(String[] args) {
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
			builder.append(args[i]).append(" ");
		}
		return builder.toString();
	}

}
