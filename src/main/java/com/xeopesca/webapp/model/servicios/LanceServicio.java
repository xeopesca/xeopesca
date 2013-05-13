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

	public static Lance findById(Long id) {
		LanceDAO lanceDao = new LanceDAO();
		Lance lance= lanceDao.find(id);
		return lance;
	}

	public static Lance updateLance(Lance lance) {
		LanceDAO lanceDao = new LanceDAO();
		Lance lanceResposta = lanceDao.update(lance);
		
		return lanceResposta;
	}
	
	
}
