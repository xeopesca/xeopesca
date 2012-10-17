package com.xeopesca.webapp.model.servicios;

import java.util.List;

import com.xeopesca.webapp.model.dao.UsuarioDAO;
import com.xeopesca.webapp.model.vos.Usuario;

public class UsuarioServicio {
	
	
	
	
	
	public List<Usuario> listaDeUsuarios(){
		UsuarioDAO userDao = new UsuarioDAO();
		List <Usuario> lista ;
		lista = userDao.lista();
		return lista;
		
		
	}
	

}
