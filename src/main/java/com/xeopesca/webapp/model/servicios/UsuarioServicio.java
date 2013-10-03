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
	
	public static Usuario getUsuario(String  login) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario userRecuperado;

		userRecuperado = userDao.finByLogin(login);
		if (null == userRecuperado) {
			return null;
		}
		
		return userRecuperado;

	}
	
	public static void removeUser(Long id) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(id);
	}
	
	public static void removeUser(Usuario usuario) {
		UsuarioDAO userDao = new UsuarioDAO();
		userDao.delete(usuario.getId());
	}

	public static void removePatron(Long id, Long idArmador) {
		UsuarioDAO userDao = new UsuarioDAO();
		Usuario usuarioBorrar = userDao.find(id);

		if (usuarioBorrar.getPatron_autoriza()== idArmador ){
			userDao.delete(id);
		}
		
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
	
	public static List<Usuario>  buscarPatronsDunArmador(long  idArmador) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.findPatronsDunArmador(idArmador);
		
		return lista;
	}
	
	public static List<Usuario>  buscarPatronsDunArmador(long  idArmador, String login) {
		List<Usuario> lista = new ArrayList<Usuario>();
		UsuarioDAO userDao = new UsuarioDAO();
		lista = userDao.findPatronsDunArmador(idArmador, login);
		
		return lista;
	}
	
	
	public static Usuario  buscarUsuario(Long id) {
		
		if (id== null) return null;
		
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
