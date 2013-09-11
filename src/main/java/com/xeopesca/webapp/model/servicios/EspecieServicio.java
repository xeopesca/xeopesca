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

import com.xeopesca.webapp.model.dao.EspecieDAO;
import com.xeopesca.webapp.model.vos.Especie;

/**
 * @author belay
 *
 */
public class EspecieServicio {

	public static List<Especie> listaDeEspecies() {
		EspecieDAO especieDao = new EspecieDAO();
		List<Especie> lista;
		lista = especieDao.lista();
		return lista;
	}

	public static void saveEspecie(Especie especie) {
		EspecieDAO especieDao = new EspecieDAO();
		especieDao.create(especie);
	}

	

	public static void removeEspecie(Especie especie) {
		EspecieDAO especieDao = new EspecieDAO();
		especieDao.delete(especie.getId());
	}

	public static void removeEspecie(Long id) {
		EspecieDAO especieDao = new EspecieDAO();
		especieDao.delete(id);
	}
	
	public static List<Especie>  buscarEspecie(String nome) {
		List<Especie> lista = new ArrayList<Especie>();
		EspecieDAO especieDao = new EspecieDAO();
		lista = especieDao.finByEspecie("%"+nome+"%");
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Especie>();
		}
		
		return lista;
	}
	
	
	public static Especie  buscarEspecie(Long id) {
		EspecieDAO especieDao = new EspecieDAO();
		Especie especieRecuperado = especieDao.find(id);
		
		if (null == especieRecuperado ){
			return null;
		}
		
		return especieRecuperado;
		
	}
	
	public static void editarEspecie(Especie especie){
		EspecieDAO especieDao = new EspecieDAO();
		especieDao.update(especie);
	}

}
