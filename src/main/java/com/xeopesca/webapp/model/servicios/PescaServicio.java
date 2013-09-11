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

import com.xeopesca.webapp.model.dao.PescaDAO;
import com.xeopesca.webapp.model.vos.Pesca;

public class PescaServicio {

	private PescaServicio(){}
	
	public static Pesca createPesca(Pesca pesca){
		Pesca saida = null;
		PescaDAO lanceDao = new PescaDAO();
		saida  = lanceDao.create(pesca);
		return saida;
	}
	
	public static void removePesca (Pesca pesca){
		PescaDAO pescaDao = new PescaDAO();
		pescaDao.delete(pesca.getId());
	}
	
	public static Pesca findById(Pesca pesca){
		Pesca saida = null;
		PescaDAO pescaDao = new PescaDAO();
		saida = pescaDao.find(pesca.getId());
		return saida;
	}
	
	public static Pesca findById(Long id){
		Pesca saida = null;
		PescaDAO pescaDao = new PescaDAO();
		
		if (id != null){
			saida = pescaDao.find(id);
		}
		
		return saida;
	}

	public static Pesca updatePesca(Pesca pesca) {
		PescaDAO pescaDao = new PescaDAO();
		Pesca saida = pescaDao.update(pesca);
		return saida;
	}
	
	
}
