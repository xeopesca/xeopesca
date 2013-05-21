package com.xeopesca.webapp.model.servicios;



import java.util.ArrayList;
import java.util.List;

import com.xeopesca.webapp.model.dao.FaenaDAO;
import com.xeopesca.webapp.model.vos.Faena;
import com.xeopesca.webapp.view.FaenaBuscador;

/**
 * @author belay
 *
 */
public class FaenaServicio {

	

	public static Faena findById(Long id) {
		FaenaDAO faenaDao = new FaenaDAO();
		Faena fae = faenaDao.find(id);
		return fae;
	}
	
	public static void saveFaena(Faena faena) {
		FaenaDAO faenaDao = new FaenaDAO();
		faenaDao.create(faena);
	}

	

	public static void removeFaena(Faena faena) {
		FaenaDAO faenaDao = new FaenaDAO();
		faenaDao.delete(faena.getId());
	}

	public static void removeFaena(Long id) {
		FaenaDAO faenaDAO = new FaenaDAO();
		faenaDAO.delete(id);
	}
	
	public static List<Faena> faenasDunBarco(Long idBarco) {
		FaenaDAO faenaDAO = new FaenaDAO();
		List<Faena> listaFaenas = faenaDAO.faenasBarco(idBarco);
		
		if (listaFaenas == null) listaFaenas = new ArrayList<Faena>();
		
		return listaFaenas;
	}

	public static List<Faena> findBuscadorFaena(Faena faena) {
		FaenaDAO faenaDAO = new FaenaDAO();
		List<Faena> listaFaenas = faenaDAO.faenasBuscador(faena);
		
		if (listaFaenas == null) listaFaenas = new ArrayList<Faena>();
		
		return listaFaenas;
		
		
	}
	
	

}
