package com.xeopesca.webapp.model.servicios;

import java.util.ArrayList;
import java.util.List;

import com.xeopesca.webapp.model.dao.BarcoDAO;
import com.xeopesca.webapp.model.vos.Barco;

/**
 * @author belay
 *
 */
public class BarcoServicio {

	public static List<Barco> listaDeBarcos() {
		BarcoDAO barcoDao = new BarcoDAO();
		List<Barco> lista;
		
		lista = barcoDao.lista();
		return lista;
	}

	public static void saveBarco(Barco barco) {
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.create(barco);
	}

	

	public static void removeBarco(Barco barco) {
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.delete(barco.getFolio());
	}

	public static void removeBarco(String folio) {
		BarcoDAO especieDao = new BarcoDAO();
		especieDao.delete(folio);
	}
	
	public static List<Barco>  buscarBarco(String folio) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		lista = barcoDao.fingByFolio("%"+folio+"%");
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	

	
	public static void updateBarco(Barco barco){
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.update(barco);
	}

}
