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

import java.util.List;

import com.xeopesca.webapp.model.dao.ParametriaDAO;
import com.xeopesca.webapp.model.vos.Parametria;

/**
 * @author belay
 *
 */
public class ParametriaServicio {

	/**
	 * Recupera un parametro da lista de parametros
	 * @param claveParametro
	 * @return List<Parametria> 
	 */
	public static List<Parametria> recuperarParametro(String claveParametro) {
		ParametriaDAO param = new ParametriaDAO();
		List<Parametria> lista;
		lista = param.findParametria(claveParametro);
		return lista;
	}



}
