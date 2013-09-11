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

import com.xeopesca.webapp.model.dao.BarcoDAO;
import com.xeopesca.webapp.model.vos.Barco;

/**
 * @author belay
 *
 */
public class BarcoServicio {

	public static List<Barco> listaDeBarcos() {
		BarcoDAO barcoDao = new BarcoDAO();
		List<Barco> lista;
		
		lista = barcoDao.lista();
		return lista;
	}

	public static void saveBarco(Barco barco) {
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.create(barco);
	}

	

	public static void removeBarco(Barco barco) {
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.delete(barco.getFolio());
	}

	public static void removeBarco(long id) {
		BarcoDAO especieDao = new BarcoDAO();
		especieDao.delete(id);
	}
	
	public static List<Barco>  buscarBarco(String folio, long id) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		
		
		lista = barcoDao.fingByFolio("%"+folio+"%", id);
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	
	public static List<Barco>  buscarBarcoArmador(long idBarco, long idArmador) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		
		
		lista = barcoDao.buscarBarcoArmador(idBarco, idArmador);
				
				
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	
	public static void updateBarco(Barco barco){
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.update(barco);
	}

	public static List<Barco> listaDeBarcos(long id) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		lista = barcoDao.fingByIdArmador(id);
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	
	public static Barco findByID(long id) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		lista = barcoDao.fingById(id);
		Barco saida = null;
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
			saida = null;
		}
		else{
			saida = lista.get(0);
		}
		
		return saida;
	}

}
