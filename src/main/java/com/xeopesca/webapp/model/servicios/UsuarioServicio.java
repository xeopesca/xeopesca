package com.xeopesca.webapp.model.servicios;

import java.util.ArrayList;
import java.util.List;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.vos.Usuario;

/**
 * @author belay
 *
 */
public class UsuarioServicio {

	public static List<Usuario> listaDeUsuarios() {
		UsuarioDAO userDao = new UsuarioDAO();
		List<Usuario> lista;
		lista = userDao.lista();
		return lista;
	}

	public static void saveUsuario(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.create(usuario);
	}

	public static boolean login(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado;

		userRecuperado = userDao.finByLogin(usuario.getLogin());
		if (null == userRecuperado) {
			return false;
		}
		if (userRecuperado.getContrasinal().equals(usuario.getContrasinal())) {
			return true;
		}
		return false;

	}

	public static void removeUser(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(usuario.getId());
	}

	public static void removeUser(Long id) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(id);
	}
	
	public static List<Usuario>  buscarUsuario(String login) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado = userDao.finByLogin(login);
		
		if (null == userRecuperado ){
			return lista;
		}
		
		lista.add(userRecuperado);
		return lista;
	}
	
	
	public static Usuario  buscarUsuario(Long id) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado = userDao.find(id);
		
		if (null == userRecuperado ){
			return null;
		}
		
		return userRecuperado;
		
	}
	
	public static List<Usuario>  buscarUsuarioSimilarLogin(String login) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.finBySimilarLogin(login);
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Usuario>();
		}
		
		return lista;
	}
	
	public static void updateUsuario(Usuario usuario){
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.update(usuario);
	}

}
