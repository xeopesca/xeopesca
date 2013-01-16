package com.xeopesca.webapp.model.servicios;

import java.util.ArrayList;
import java.util.List;

import com.xeopesca.webapp.model.dao.ArteDAO;
import com.xeopesca.webapp.model.vos.Arte;

/**
 * @author belay
 *
 */
public class ArteServicio {

	public static List<Arte> listaDeArtes() {
		ArteDAO arteDao = new ArteDAO();
		List<Arte> lista;
		lista = arteDao.lista();
		return lista;
	}

	public static void saveArte(Arte arte) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.create(arte);
	}

	

	public static void removeArte(Arte arte) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.delete(arte.getId());
	}

	public static void removeArte(Long id) {
		ArteDAO arteDao = new ArteDAO();
		arteDao.delete(id);
	}
	
	public static List<Arte>  buscarArte(String nome) {
		List<Arte> lista = new ArrayList<Arte>();
		ArteDAO arteDao = new ArteDAO();
		lista = arteDao.finByArte("%"+nome+"%");
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Arte>();
		}
		
		return lista;
	}
	
	
	public static Arte  buscarArte(Long id) {
		ArteDAO arteDao = new ArteDAO();
		Arte arteRecuperado = arteDao.find(id);
		
		if (null == arteRecuperado ){
			return null;
		}
		
		return arteRecuperado;
		
	}
	
	public static void updateArte(Arte arte){
		ArteDAO arteDao = new ArteDAO();
		arteDao.update(arte);
	}

}
