/* --------------------------------------------------------------------
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

import com.xeopesca.webapp.model.dao.ArteDAO;
import com.xeopesca.webapp.model.vos.Arte;

/**
 * @author belay
 *
 */
public class ArteServicio {

	public static List<Arte> listaDeArtes() {
		ArteDAO arteDao = new ArteDAO();
		List<Arte> lista;
		lista = arteDao.lista();
		return lista;
	}

	public static void saveArte(Arte arte) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.create(arte);
	}

	

	public static void removeArte(Arte arte) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.delete(arte.getId());
	}

	public static void removeArte(Long id) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.delete(id);
	}
	
	public static List<Arte>  buscarArte(String nome) {
		List<Arte> lista = new ArrayList<Arte>();
		ArteDAO arteDao = new ArteDAO();
		lista = arteDao.finByArte("%"+nome+"%");
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Arte>();
		}
		
		return lista;
	}
	
	
	public static Arte  buscarArte(Long id) {
		ArteDAO arteDao = new ArteDAO();
		Arte arteRecuperado = arteDao.find(id);
		
		if (null == arteRecuperado ){
			return null;
		}
		
		return arteRecuperado;
		
	}
	
	public static void updateArte(Arte arte){
		ArteDAO arteDao = new ArteDAO();
		arteDao.update(arte);
	}

}
