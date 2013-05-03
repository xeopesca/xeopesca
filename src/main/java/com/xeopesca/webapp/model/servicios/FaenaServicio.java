package com.xeopesca.webapp.model.servicios;



import com.xeopesca.webapp.model.dao.FaenaDAO;
import com.xeopesca.webapp.model.vos.Faena;

/**
 * @author belay
 *
 */
public class FaenaServicio {

	

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
	
	
	
	

}
