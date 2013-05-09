package com.xeopesca.webapp.model.servicios;

import com.xeopesca.webapp.model.dao.LanceDAO;
import com.xeopesca.webapp.model.vos.Lance;

public class LanceServicio {

	private LanceServicio(){}
	
	public static Lance createLance(Lance lance){
		Lance saida = null;
		LanceDAO lanceDao = new LanceDAO();
		saida  = lanceDao.create(lance);
		return saida;
	}
	
	public static void removeLance (Lance lance){
		LanceDAO lanceDao = new LanceDAO();
		lanceDao.delete(lance.getId());
	}
	
	
}
