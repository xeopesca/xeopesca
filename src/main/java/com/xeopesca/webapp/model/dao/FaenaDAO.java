package com.xeopesca.webapp.model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.xeopesca.util.JPAUtil;
import com.xeopesca.util.dao.GenericDaoHibernate;
import com.xeopesca.webapp.model.vos.Faena;


public class FaenaDAO extends GenericDaoHibernate<Faena>{

	public List<Faena> buscadorAvanzado(long idBarco){
		List<Faena> saida = new ArrayList<Faena>();
		EntityManager em = JPAUtil.createEntityManager();		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		
		return saida;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Faena> lista(long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM  Faena f " +
				           " WHERE (f.idBarco = :idBarco) " 
						 + " ORDER by f.id  ASC";
		List<Faena> saida = em.createQuery(queryStri).getResultList();

		return saida;
	}

	public  List<Faena> faenasBarco(Long idBarco) {
		EntityManager em = JPAUtil.createEntityManager();
		em.getTransaction().begin();
		String queryStri = " FROM Faena f " +
						   " WHERE (f.idbarco = :idbarco) " 
						 + " ORDER by f.id  DESC ";

		@SuppressWarnings("unchecked")
		List<Faena> saida = em.createQuery(queryStri).setParameter("idbarco", idBarco).getResultList();
		
		return saida;
	}


	public List<Faena> faenasBuscador(Faena faena) {
		EntityManager em = JPAUtil.createEntityManager();
		CriteriaBuilder cb = em.getEntityManagerFactory().getCriteriaBuilder();

	    CriteriaQuery<Faena> criteriaQuery = cb.createQuery(Faena.class);

	    //Indicamos la entidad sobre la cual necesitamos crear la consulta
	    Root<Faena> faenaER = criteriaQuery.from(Faena.class);	
	    //Creamos un predicado conjunction, que vienen a ser un tipo de restriccion en el query
        Predicate conjunction = cb.conjunction();
    
        /**
         * APLICAMOS OS FILTROS DA BUSQUEDA
         * 
         * **/
        
       // agregamos una expresion al conjunction, greater than
       if (faena.getIdbarco() != 0){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("idbarco").as(Integer.class), faena.getIdbarco()));
       }
       
       if (faena.getIdarte() != null){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("idarte").as(Integer.class), faena.getIdarte()));
       }
       if (faena.getEstado_ceo() != null){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("estado_ceo").as(Integer.class), faena.getEstado_ceo() ));
       }
       
       if (faena.getEstado_mar()!= null){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("estado_mar").as(Integer.class), faena.getEstado_mar() ));
       }
       
       if (faena.getLua()!= null){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("lua").as(Integer.class), faena.getLua()));
       }
       
       if (faena.getDireccion_vento()!= null){ 
    	   conjunction.getExpressions().add(cb.equal(faenaER.get("direccion_vento").as(Integer.class), faena.getDireccion_vento()));
       }
       //Entre estas datas de incio
       /*if (faena.getData_inicio()!=null){
    	   conjunction.getExpressions().add(cb.gt(faenaER.get("data_inicio").as(java.sql.Date.class), new java.sql.Date(faena.getData_inicio().getTime())));
       }
       if (faena.getData_inicio()!=null){
    	   conjunction.getExpressions().add(cb.gt(faenaER.get("data_inicio").as(Integer.class), faena.getDireccion_vento()));
       }
       */
       
	   
       // si el conjunction posee mas de cero expresiones, entonces las agregamos al query con el metodo where
       if (conjunction.getExpressions().size() > 0) {
           criteriaQuery.where(conjunction);
       }
       
	   // retornamos una lista de la entidad especificada
	     List<Faena> saida = em.createQuery(criteriaQuery).getResultList();
	  
		return saida;
		
		
	}

}
