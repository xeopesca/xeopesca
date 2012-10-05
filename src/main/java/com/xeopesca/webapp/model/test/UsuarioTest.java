package com.xeopesca.webapp.model.test;


import java.util.List;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.vos.Usuario;
import com.xeopesca.webapp.model.vos.Usuario2;

public class UsuarioTest
{
	private static final String separador = "*********************************************************************";

	public static void main(String[] args) {
	/*	
		System.out.println(separador);
		System.out.println("Listado de Usuarios");
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<? extends Usuario>  listaUsuarios = usuarioDAO.listUsuarios();
		//List<Usuario>  listaUsuarios = usuarioDAO.listUsuarios();

		for (int i= 0; i<listaUsuarios.size(); i++ ) {
			
			Usuario user = (Usuario) listaUsuarios.get(i);
			System.out.println("Usuario: \t"+user.getLogin()+"\t nome: \t"+user.getNome());
		
		}*/
		
		UsuarioDAO userDao  = new UsuarioDAO();
		System.out.println(separador);
		System.out.println("Update Usuario");
		Usuario2 usuario = new Usuario2();
		usuario.setLogin("loginTest");
		usuario.setNome("nomeTest");
		userDao.Store("loginTest", "nomeTest");
		
		System.out.println(separador);
		
		
		
		
	}
}
