package com.xeopesca.webapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Usuario;
import com.xeopesca.webapp.model.vos.Usuario;

public class UsuarioDAO  extends GenericDaoHibernate<Usuario>
{

	/*
	public void Save(String nome, String login)
	{
			EntityManager em = JPAUtil.createEntityManager();
			em.getTransaction().begin();
			Usuario user = new Usuario();
			user.setLogin(login);
			user.setNome(nome);
			em.persist(user);
			em.getTransaction().commit();
			em.close();
		
	}
	
	public void Save(Usuario user)
	{
			EntityManager em = JPAUtil.createEntityManager();
			em.getTransaction().begin();

			em.persist(user);
			em.getTransaction().commit();
			em.close();
		
	}*/
	
	
	
	

}

