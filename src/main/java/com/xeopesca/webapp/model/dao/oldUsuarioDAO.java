package com.xeopesca.webapp.model.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xeopesca.util.HibernateUtil;
import com.xeopesca.webapp.model.vos.Usuario;

public class oldUsuarioDAO {

	@SuppressWarnings("unchecked")
	public void listUsuarios() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Usuario> usuarios = session.createQuery("from Usuario").list();

			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getLogin());
			}

			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void updateUsuario(Usuario user) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			List<Usuario> usuarios = session.createQuery("from Usuario").list();

			for (Usuario usuario : usuarios) {
				System.out.println(usuario.getLogin());
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
