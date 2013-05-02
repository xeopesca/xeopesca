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

	public static void removeBarco(long id) {
		BarcoDAO especieDao = new BarcoDAO();
		especieDao.delete(id);
	}
	
	public static List<Barco>  buscarBarco(String folio, long id) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		
		
		lista = barcoDao.fingByFolio("%"+folio+"%", id);
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	
	public static List<Barco>  buscarBarcoArmador(long idBarco, long idArmador) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		
		
		lista = barcoDao.buscarBarcoArmador(idBarco, idArmador);
				
				
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}
	
	public static void updateBarco(Barco barco){
		BarcoDAO barcoDao = new BarcoDAO();
		barcoDao.update(barco);
	}

	public static List<Barco> listaDeBarcos(long id) {
		List<Barco> lista = new ArrayList<Barco>();
		BarcoDAO barcoDao = new BarcoDAO();
		lista = barcoDao.fingByIdArmador(id);
	
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Barco>();
		}
		
		return lista;
	}

}
