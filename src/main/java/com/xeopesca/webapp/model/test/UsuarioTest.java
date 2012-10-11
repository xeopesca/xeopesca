package com.xeopesca.webapp.model.test;


import java.util.List;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.vos.Usuario;
import com.xeopesca.webapp.model.vos.Usuario2;

public class UsuarioTest
{
	private static final String separador = "*********************************************************************";

	public static void main(String[] args) {

		UsuarioDAO userDao  = new UsuarioDAO();
		System.out.println(separador);
		System.out.println("Create Usuario");
		Usuario usuario = new Usuario();
		usuario.setLogin("pableras");
		usuario.setNome("nomeTest");
		usuario.setApelidos("apelidos");
		usuario.setTipousuario("probas");
		usuario.setContrasinal("xxxx");
		
		userDao.create(usuario);
		
		System.out.println(separador);
		
		
		
		
	}
}
