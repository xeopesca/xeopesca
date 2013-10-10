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

import com.xeopesca.webapp.model.dao.LanceDAO;
import com.xeopesca.webapp.model.vos.Lance;
/**
 * 
 * @author belay
 *
 */
public class LanceServicio {

	private LanceServicio(){}
	/**
	 * Crea un lance no sistema
	 * @param lance
	 * @return Lance
	 */
	public static Lance createLance(Lance lance){
		Lance saida = null;
		LanceDAO lanceDao = new LanceDAO();
		saida  = lanceDao.create(lance);
		return saida;
	}
	
	/**
	 * Elimina un  lance 
	 * @param lance
	 */
	public static void removeLance (Lance lance){
		LanceDAO lanceDao = new LanceDAO();
		lanceDao.delete(lance.getId());
	}

	/**
	 * Busca un lance por id
	 * @param id
	 * @return Lance
	 */
	public static Lance findById(Long id) {
		LanceDAO lanceDao = new LanceDAO();
		Lance lance= lanceDao.find(id);
		return lance;
	}

	/**
	 * Actualiza información dun lance
	 * @param lance
	 * @return Lance
	 */
	public static Lance updateLance(Lance lance) {
		LanceDAO lanceDao = new LanceDAO();
		Lance lanceResposta = lanceDao.update(lance);
		
		return lanceResposta;
	}
	
	
}
