package com.xeopesca.webapp.model.servicios;

import java.util.List;

import com.xeopesca.webapp.model.dao.ParametriaDAO;
import com.xeopesca.webapp.model.vos.Parametria;

/**
 * @author belay
 *
 */
public class ParametriaServicio {

	public static List<Parametria> recuperarParametro(String claveParametro) {
		ParametriaDAO param = new ParametriaDAO();
		List<Parametria> lista;
		lista = param.findParametria(claveParametro);
		return lista;
	}



}
