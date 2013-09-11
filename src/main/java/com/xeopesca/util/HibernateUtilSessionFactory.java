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
package com.xeopesca.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.xeopesca.webapp.model.vos.Usuario;


@SuppressWarnings("deprecation")
public class HibernateUtilSessionFactory {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new AnnotationConfiguration()
								.configure()
								.addPackage("com.xeopesca.webapp.model.vos") //the fully qualified package name
								.addAnnotatedClass(Usuario.class)
								.buildSessionFactory();

		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	@SuppressWarnings("unused")
	public static SessionFactory getSessionFactory() {
		Session session = sessionFactory.openSession();
		return sessionFactory;
	}
}
