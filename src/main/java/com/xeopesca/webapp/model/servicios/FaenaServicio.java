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

import com.xeopesca.webapp.model.dao.FaenaDAO;
import com.xeopesca.webapp.model.vos.Faena;

/**
 * @author belay
 * 
 */
public class FaenaServicio {

	/**
	 * Busca unha faena por ID
	 * 
	 * @param id
	 * @return Faena
	 */
	public static Faena findById(Long id) {
		FaenaDAO faenaDao = new FaenaDAO();
		Faena fae = faenaDao.find(id);
		return fae;
	}

	/**
	 * Garda unha faena no sistema
	 * 
	 * @param faena
	 */
	public static void saveFaena(Faena faena) {
		FaenaDAO faenaDao = new FaenaDAO();
		faenaDao.create(faena);
	}

	/***
	 * Actualiza a información dunha faena
	 * 
	 * @param faena
	 */
	public static void updateFaena(Faena faena) {
		FaenaDAO faenaDao = new FaenaDAO();
		faenaDao.update(faena);
	}

	/***
	 * Elimina unha faena
	 * 
	 * @param faena
	 */
	public static void removeFaena(Faena faena) {
		FaenaDAO faenaDao = new FaenaDAO();
		faenaDao.delete(faena.getId());
	}

	/***
	 * Elimina unha faena por ID
	 * 
	 * @param id
	 */
	public static void removeFaena(Long id) {
		FaenaDAO faenaDAO = new FaenaDAO();
		faenaDAO.delete(id);
	}

	/**
	 * Faenas dun barco
	 * 
	 * @param idBarco
	 * @return List<Faena>
	 */
	public static List<Faena> faenasDunBarco(Long idBarco) {
		FaenaDAO faenaDAO = new FaenaDAO();
		List<Faena> listaFaenas = faenaDAO.faenasBarco(idBarco);

		if (listaFaenas == null)
			listaFaenas = new ArrayList<Faena>();

		return listaFaenas;
	}

	/**
	 * Busca por faena
	 * 
	 * @param faena
	 * @return List<Faena> 
	 */
	public static List<Faena> findBuscadorFaena(Faena faena) {
		FaenaDAO faenaDAO = new FaenaDAO();
		List<Faena> listaFaenas = faenaDAO.faenasBuscador(faena);

		if (listaFaenas == null)
			listaFaenas = new ArrayList<Faena>();

		return listaFaenas;

	}

	/**
	 * Buscador avanzao
	 * 
	 * @param faena
	 * @param barcos
	 * @return List<Faena>
	 */
	public static List<Faena> findBuscadorFaena(Faena faena, String barcos) {
		FaenaDAO faenaDAO = new FaenaDAO();
		List<Faena> listaFaenas = faenaDAO.faenasBuscador(faena);

		if (listaFaenas == null)
			listaFaenas = new ArrayList<Faena>();

		return listaFaenas;

	}

}
