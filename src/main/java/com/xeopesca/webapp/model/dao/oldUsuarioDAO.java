package com.xeopesca.webapp.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xeopesca.util.HibernateUtilSessionFactory;
import com.xeopesca.webapp.model.vos.Usuario2;

public class oldUsuarioDAO {

	@SuppressWarnings("unchecked")
	public void listUsuarios() {
		Session session = HibernateUtilSessionFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Usuario2> usuario2s = session.createQuery("from Usuario").list();

			for (Usuario2 usuario2 : usuario2s) {
				System.out.println(usuario2.getLogin());
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateUsuario(Usuario2 user) {
		Session session = HibernateUtilSessionFactory.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Usuario2> usuario2s = session.createQuery("from Usuario").list();

			for (Usuario2 usuario2 : usuario2s) {
				System.out.println(usuario2.getLogin());
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	

	public static void main(String[] args) {

		oldUsuarioDAO oldUsuarioDAO = new oldUsuarioDAO();

		oldUsuarioDAO.listUsuarios();
	}

}
