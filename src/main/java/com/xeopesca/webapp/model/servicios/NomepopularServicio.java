package com.xeopesca.webapp.model.servicios;

import java.util.ArrayList;
import java.util.List;

import com.xeopesca.webapp.model.dao.NomepopularDAO;
import com.xeopesca.webapp.model.vos.Nomepopular;

/**
 * @author belay
 *
 */
public class NomepopularServicio {

	public static List<Nomepopular>listaDeNomesPopulares () {
		NomepopularDAO nomepopular = new NomepopularDAO();
		List<Nomepopular> lista;
		lista = nomepopular.lista();
		return lista;
	}

	public static void saveNomePopular(Nomepopular nomepopular) {
		NomepopularDAO nomepopularDao = new NomepopularDAO();
		nomepopularDao.create(nomepopular);
	}

	
	public static void removeNomePopular(Long id) {
		NomepopularDAO nomepopularDao = new NomepopularDAO();
		nomepopularDao.delete(id);
	
	}
	
	public static void removeNomePopular(Nomepopular nomepopular) {
		NomepopularDAO nomepopularDao = new NomepopularDAO();
		nomepopularDao.delete(nomepopular.getId());
	
	}

	
	
	public static List<Nomepopular>  buscarNomePopular(String nome) {
		List<Nomepopular> lista = new ArrayList<Nomepopular>();
		NomepopularDAO nomePopularDao = new NomepopularDAO();
		lista = nomePopularDao.findByNome("%"+nome+"%");
		
		if (null == lista || lista.isEmpty() ){
			lista = new ArrayList<Nomepopular>();
		}
		
		return lista;
	}
	
	
	public static Nomepopular  buscarNomepopular(Long id) {
		NomepopularDAO nomepopularDao = new NomepopularDAO();
		Nomepopular nomepopular = nomepopularDao.find(id);
		
		if (null == nomepopular ){
			return null;
		}
		
		return nomepopular;
		
	}
	
	public static void updateNomepopularDao(Nomepopular nomepopular){
		NomepopularDAO nomepopularDao= new NomepopularDAO();
		nomepopularDao.update(nomepopular);
	}

}
