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
