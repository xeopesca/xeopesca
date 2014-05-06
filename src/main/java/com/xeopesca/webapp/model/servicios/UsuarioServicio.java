/* --------------------------------------------------------------------
 This file is part of xeoPesca

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
package com.xeopesca.webapp.model.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.vos.Usuario;


/**
 * @author belay
 *
 */
@Service
public class UsuarioServicio {


	@Autowired
	private static UsuarioDAO usuarioDao = new UsuarioDAO();
	
	/**
	 * Lista de usuarios que existen no sistema
	 * @return List<Usuario>
	 */
	public static List<Usuario> listaDeUsuarios() {
		UsuarioDAO userDao = new UsuarioDAO();
		List<Usuario> lista;
		lista = userDao.lista();
		
		lista = usuarioDao.lista();
		
		return lista;
	}

	/**
	 * Da de alta un novo usuario no sistema.
	 * @param usuario
	 */
	public static void saveUsuario(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.create(usuario);
	}

	/**
	 * Comproba que un usuario existe no sistema
	 * @param usuario
	 * @return boolean
	 */
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
	
	/**
	 * Recupera un usuario por login
	 * @param login
	 * @return Usuario
	 */
	public static Usuario getUsuario(String  login) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado;

		userRecuperado = userDao.finByLogin(login);
		if (null == userRecuperado) {
			return null;
		}
		
		return userRecuperado;

	}
	
	/**
	 * Borrar un usuario por id
	 * @param id
	 */
	public static void removeUser(Long id) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(id);
	}
	
	/**
	 * Borrar un usuario
	 * @param usuario
	 */
	public static void removeUser(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(usuario.getId());
	}

	/**
	 * Borrar un patron do sistema 
	 * @param id
	 * @param idArmador
	 */
	public static void removePatron(Long id, Long idArmador) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario usuarioBorrar = userDao.find(id);

		if (usuarioBorrar.getPatron_autoriza()== idArmador ){
			userDao.delete(id);
		}
		
	}
	
	/**
	 * Busca un usuario por login
	 * @param login
	 * @return List<Usuario>
	 */
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
	
	/**
	 * Busca os patrons dun armador
	 * @param idArmador
	 * @return List<Usuario>
	 */
	public static List<Usuario>  buscarPatronsDunArmador(long  idArmador) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.findPatronsDunArmador(idArmador);
		
		return lista;
	}
	
	/**
	 * Busca os patrons dun armador
	 * @param idArmador
	 * @param login
	 * @return List<Usuario>
	 */
	public static List<Usuario>  buscarPatronsDunArmador(long  idArmador, String login) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.findPatronsDunArmador(idArmador, login);
		
		return lista;
	}
	
	
	/**
	 * Busca un usuario por id
	 * @param id
	 * @return Usuario
	 */
	public static Usuario  buscarUsuario(Long id) {
		
		if (id== null) return null;
		
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado = userDao.find(id);
		
		if (null == userRecuperado ){
			return null;
		}
		
		return userRecuperado;
		
	}
	
	/**
	 * Busca usuarios similares por login
	 * @param login
	 * @return List<Usuario>
	 */
	public static List<Usuario>  buscarUsuarioSimilarLogin(String login) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.finBySimilarLogin(login);
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Usuario>();
		}
		
		return lista;
	}
	
	/**
	 * Actualiza a informaci'on dun usuario
	 * @param usuario
	 */
	public static void updateUsuario(Usuario usuario){
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.update(usuario);
	}

	public UsuarioDAO getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDAO usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
}
