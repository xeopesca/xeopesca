package com.xeopesca.webapp.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.xeopesca.tutorial.util.JPAUtil;
import com.xeopesca.webapp.model.vos.Usuario;

public class UsuarioDAO
{

	public List listUsuarios()
	{

		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		Query query = em.createQuery("from Event ", Usuario.class);
		List <? extends Usuario> salida = query.getResultList();
		return query.getResultList();

	}

	public void Store(String nome, String login)
	{
		if (login.length() == 0)
		{
			throw new RuntimeException("Login is empty ");
		}
		if (findById(login) == null)
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
	}

	public Usuario findById(String login)
	{
		if (login.trim().length() == 0)
		{
			throw new RuntimeException("Login is empty ");
		}
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery(" select u from Usuario u "
				+ " where (u.login = :login) ", Usuario.class);
		query.setParameter("filter", login);

		List<Usuario> listaUsuarios = ((Query) query).getResultList();

		/***/
		// TODO
		if (listaUsuarios.isEmpty())
		{
			return null;
		}

		return listaUsuarios.get(0);

	}

}

