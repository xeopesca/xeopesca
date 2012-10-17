package com.xeopesca.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.xeopesca.webapp.model.vos.Usuario2;

public class OLD_HibernateUtilSessionFactory {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration()
								.configure()
								.addPackage("com.xeopesca.webapp.model.vos") //the fully qualified package name
								.addAnnotatedClass(Usuario2.class)
								.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		Session session = sessionFactory.openSession();
		return sessionFactory;
	}
}
